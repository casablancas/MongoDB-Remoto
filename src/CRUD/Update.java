/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 *
 * @author Alejandro
 */
public class Update {

    public Update() {
    }
    
    public void updateDocument()
    {
        System.out.println("Accediendo a la base de datos...");
        String textUri = "mongodb://luis:conde@ds048878.mongolab.com:48878/MongoLab-l";
        //String textUri = "mongodb://alex:jimenez@ds023438.mlab.com/?authSource=museosapp&authMechanism=MONGODB-X509";
        MongoClientURI uri = new MongoClientURI(textUri);
        MongoClient mongoClient = new MongoClient(uri);
           
        DB db = mongoClient.getDB( "MongoLab-l" );
        
        DBCollection items = db.getCollection("piezas");
        
        System.out.println("Actualizando el documento de la colección...");
        
        BasicDBObject findTestItemQuery = new BasicDBObject();
        findTestItemQuery.put("id_pieza", "6");
        DBCursor testItemsCursor = items.find(findTestItemQuery);
        if(testItemsCursor.hasNext()) {
            DBObject testCodeItem = testItemsCursor.next();
            testCodeItem.put("nombre", "Holi bb como has estado");
            items.save(testCodeItem);
            System.out.println("Documento actualizado.");
        }
    }
}
