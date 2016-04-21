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
public class Delete {

    public Delete() {
    }
    
     public void deleteDocument()
     {
        System.out.println("Accediendo a la base de datos...");
        String textUri = "mongodb://luis:conde@ds048878.mongolab.com:48878/MongoLab-l";
        //String textUri = "mongodb://alex:jimenez@ds023438.mlab.com/?authSource=museosapp&authMechanism=MONGODB-X509";
        MongoClientURI uri = new MongoClientURI(textUri);
        MongoClient mongoClient = new MongoClient(uri);
           
        DB db = mongoClient.getDB( "MongoLab-l" );
        
        DBCollection items = db.getCollection("piezas");
         
        System.out.println("Eliminando el documento de la colección...");
        
        BasicDBObject deleteQuery = new BasicDBObject();
        deleteQuery.put("id_pieza", "6");
        DBCursor cursor = items.find(deleteQuery);
        System.out.println("Eliminando documento...");
        while (cursor.hasNext()) {
            DBObject item = cursor.next();
            items.remove(item);
            System.out.println("Se ha eliminado el documento requerido.");
        }
        mongoClient.close();
     }
}
