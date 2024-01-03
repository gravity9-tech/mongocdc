package com.gravity9.mongocdc;

import com.mongodb.client.model.changestream.FullDocument;
import com.mongodb.client.model.changestream.FullDocumentBeforeChange;

public class MongoConfig {

	private String connectionUri;

	private String databaseName;

	private String collectionName;

	private int partitions;

	private String workerConfigCollectionName;

	private String clusterConfigCollectionName;

	private FullDocument fullDocument;

	private FullDocumentBeforeChange fullDocumentBeforeChange;

	private long maxAwaitTimeInMs;

	public MongoConfig(MongoConfigBuilder mongoConfigBuilder) {
		this.connectionUri = mongoConfigBuilder.connectionUri;
		this.databaseName = mongoConfigBuilder.databaseName;
		this.collectionName = mongoConfigBuilder.collectionName;
		this.partitions = mongoConfigBuilder.partitions;
		this.workerConfigCollectionName = mongoConfigBuilder.workerConfigCollectionName;
		this.clusterConfigCollectionName = mongoConfigBuilder.clusterConfigCollectionName;
		this.fullDocument = mongoConfigBuilder.fullDocument;
		this.fullDocumentBeforeChange = mongoConfigBuilder.fullDocumentBeforeChange;
		this.maxAwaitTimeInMs = mongoConfigBuilder.maxAwaitTimeInMs;
	}

	public String getConnectionUri() {
		return connectionUri;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public int getPartitions() {
		return partitions;
	}

	public String getWorkerConfigCollectionName() {
		return workerConfigCollectionName;
	}

	public String getClusterConfigCollectionName() {
		return clusterConfigCollectionName;
	}

	public FullDocument getFullDocument() {
		return fullDocument;
	}

	public FullDocumentBeforeChange getFullDocumentBeforeChange() {
		return fullDocumentBeforeChange;
	}

	public long getMaxAwaitTimeInMs() {
		return maxAwaitTimeInMs;
	}

	public static class MongoConfigBuilder {

		private String connectionUri;

		private String databaseName;

		private String collectionName;

		private int partitions;

		private String workerConfigCollectionName = "changeStreamWorkerConfig";

		private String clusterConfigCollectionName = "changeStreamClusterConfig";

		private FullDocument fullDocument = FullDocument.UPDATE_LOOKUP;

		private FullDocumentBeforeChange fullDocumentBeforeChange = FullDocumentBeforeChange.OFF;

		@SuppressWarnings("checkstyle:magicnumber")
		private long maxAwaitTimeInMs = 1000;

		public MongoConfigBuilder connectionUri(String connectionUri) {
			this.connectionUri = connectionUri;
			return this;
		}

		public MongoConfigBuilder databaseName(String databaseName) {
			this.databaseName = databaseName;
			return this;
		}

		public MongoConfigBuilder collectionName(String collectionName) {
			this.collectionName = collectionName;
			return this;
		}

		public MongoConfigBuilder partitions(int partitions) {
			this.partitions = partitions;
			return this;
		}

		public MongoConfigBuilder workerConfigCollectionName(String workerConfigCollectionName) {
			this.workerConfigCollectionName = workerConfigCollectionName;
			return this;
		}

		public MongoConfigBuilder clusterConfigCollectionName(String clusterConfigCollectionName) {
			this.clusterConfigCollectionName = clusterConfigCollectionName;
			return this;
		}

		public MongoConfigBuilder fullDocument(FullDocument fullDocument) {
			this.fullDocument = fullDocument;
			return this;
		}

		public MongoConfigBuilder fullDocumentBeforeChange(FullDocumentBeforeChange fullDocumentBeforeChange) {
			this.fullDocumentBeforeChange = fullDocumentBeforeChange;
			return this;
		}

		public MongoConfigBuilder maxAwaitTimeInMs(long maxAwaitTimeInMs) {
			this.maxAwaitTimeInMs = maxAwaitTimeInMs;
			return this;
		}
		public MongoConfig build() {
			return new MongoConfig(this);
		}
	}

}