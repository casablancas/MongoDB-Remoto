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
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 *
 * @author Alejandro
 */
public class ReadMuseos {

    public ReadMuseos() {
    }
    
    public void readDocumt(String qery){
    
        System.out.println("Accediendo a la base de datos...");
        String textUri = "mongodb://luis:conde@ds048878.mongolab.com:48878/MongoLab-l";
        //String textUri = "mongodb://alex:jimenez@ds023438.mlab.com/?authSource=museosapp&authMechanism=MONGODB-X509";
        MongoClientURI uri = new MongoClientURI(textUri);
        MongoClient mongoClient = new MongoClient(uri);
           
        DB db = mongoClient.getDB( "MongoLab-l" );
        
        DBCollection items = db.getCollection("museos");
        
        BasicDBObject query = new BasicDBObject();
        query.put("nombre", qery);
        DBCursor cursor = items.find(query);
        // Print out "highest" priority items
        //System.out.println("query con la pieza 6:\n");
        System.out.println("Leyendo el documento de la colección...");
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
            System.out.println("Acceso realizado correctamente.");
        }
        mongoClient.close();
    }
}
