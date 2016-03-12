/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 *
 * @author Alejandro
 */
public class Create {

    public Create() {
    }
     public void createDocument()
     {
           System.out.println("Accediendo a la base de datos...");
           String textUri = "mongodb://luis:conde@ds048878.mongolab.com:48878/MongoLab-l";
           //String textUri = "mongodb://alex:jimenez@ds023438.mlab.com/?authSource=museosapp&authMechanism=MONGODB-X509";
           MongoClientURI uri = new MongoClientURI(textUri);
           MongoClient mongoClient = new MongoClient(uri);
           
           DB db = mongoClient.getDB( "MongoLab-l" );
           
           System.out.println("Creando el documento en la colección...");
           
           DBCollection items = db.getCollection("piezas");
           BasicDBObject doc1 = new BasicDBObject();
           doc1.put("nombre", "Probando inserción");
           doc1.put("categoria", "sin categoria");
           doc1.put("id_pieza", "6");
           doc1.put("autor", "No tiene un autor");
           doc1.put("ano", "No tiene un año");
           doc1.put("descripcion", "Esta es una pieza que se inserta como prueba y será eliminada.");
           doc1.put("imagen", "http://res.cloudinary.com/lconder/image/upload/v1440913055/sample.jpg");
           items.insert(doc1);
           System.out.println("Se ha insertado 1 documento a la colección.");
           mongoClient.close();
           
           /*
           BasicDBObjectBuilder documentBuilderDetail = BasicDBObjectBuilder.start()
            .add("records", 99)
            .add("index", "vps_index1")
            .add("active", "true");
           */
     }
}
