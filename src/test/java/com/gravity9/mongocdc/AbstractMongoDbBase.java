package com.gravity9.mongocdc;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testcontainers.containers.MongoDBContainer;

public abstract class AbstractMongoDbBase {

    private static final MongoDBContainer MONGO_DB_CONTAINER =
            new MongoDBContainer("mongo:4.2.8");
    private static final String COLL_NAME = "testCollection";
    private static final String DB_NAME = "test";

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;

    protected String getConnectionUri() {
        return MONGO_DB_CONTAINER.getReplicaSetUrl();
    }

    protected String getTestCollectionName() {
        return COLL_NAME;
    }

    protected String getDatabaseName() {
        return DB_NAME;
    }

    protected String getWorkerConfigCollectionName() {
        return "changeStreamWorkerConfig";
    }

    protected String getClusterConfigCollectionName() {
        return "changeStreamClusterConfig";
    }

    @BeforeAll
    public static void setUpAll() {
        MONGO_DB_CONTAINER.start();
    }

    @AfterAll
    public static void tearDownAll() {
        if (!MONGO_DB_CONTAINER.isShouldBeReused()) {
            MONGO_DB_CONTAINER.stop();
        }
    }

    @BeforeEach
    public void setup() {
        mongoClient = MongoClientProvider.createClient(getConnectionUri());
        mongoDatabase = mongoClient.getDatabase(getDatabaseName());
    }

    @AfterEach
    public void cleanUp() {
        mongoDatabase.getCollection(getTestCollectionName()).drop();
        mongoDatabase.getCollection(getWorkerConfigCollectionName())
                .deleteMany(Filters.eq("collection", getTestCollectionName()));
        mongoDatabase.getCollection(getClusterConfigCollectionName())
                .deleteMany(Filters.eq("collection", getTestCollectionName()));
    }


}
