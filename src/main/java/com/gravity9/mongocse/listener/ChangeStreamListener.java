package com.gravity9.mongocse.listener;

import com.mongodb.client.model.changestream.ChangeStreamDocument;
import org.bson.Document;

public interface ChangeStreamListener {

	void handle(ChangeStreamDocument<Document> event);
}
