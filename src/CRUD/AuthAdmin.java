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
public class AuthAdmin {
    
    public AuthAdmin()
    {}
   
    public void readDocumt(String qery1, String qery2){
    
        System.out.println("Accediendo a la base de datos...");
        String textUri = "mongodb://alex:jimenez@ds023438.mlab.com:23438/museosapp";
        //String textUri = "mongodb://alex:jimenez@ds023438.mlab.com/?authSource=museosapp&authMechanism=MONGODB-X509";
        MongoClientURI uri = new MongoClientURI(textUri);
        MongoClient mongoClient = new MongoClient(uri);
           
        DB db = mongoClient.getDB( "museosapp" );
        
        DBCollection items = db.getCollection("usersAdmin");
        
        BasicDBObject user = new BasicDBObject();
        BasicDBObject pass = new BasicDBObject();
        user.put("user", qery1);
        pass.put("password", qery2);
        DBCursor cursor = items.find(user);
        DBCursor cursor2 = items.find(pass);
        // Print out "highest" priority items
        //System.out.println("query con la pieza 6:\n");
        System.out.println("Leyendo el documento de la colección...");
        
        //if(cursor.hasNext()){System.out.println("Se ha encontrado en la base...");}
          //  else{System.out.println("NO se encontró en la base...");}
        
        boolean bandUser = false;
        boolean bandPass = false;
          
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
            System.out.println("Acceso realizado correctamente.");
            bandUser=true;
            
            if(cursor.hasNext()){System.out.println("Se ha encontrado en la base...");}
            else{System.out.println("NO se encontró en la base...");}
        }System.out.println(bandUser);
        
        while (cursor2.hasNext()) {
            System.out.println(cursor2.next());
            System.out.println("Acceso realizado correctamente.");
            bandPass=true;
            
            if(cursor2.hasNext()){System.out.println("Se ha encontrado en la base...");}
            else{System.out.println("NO se encontró en la base...");}
        }System.out.println(bandPass);
        
        mongoClient.close();
    }
    
    public static void main(String a[])
    {
        AuthAdmin auth = new AuthAdmin();
        auth.readDocumt("admin2","123");
    }
}
