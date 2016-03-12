/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongoremoto;

import CRUD.Update;
import CRUD.Delete;
import CRUD.Read;
import CRUD.Create;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoDatabase;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;
import Objetcs.Pieza;

/**
 *
 * @author Alejandro
 */
public class MongoRemoto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        // TODO code application logic here
        
        //Por defecto se conecta a 127.0.0.1:27017
        //MongoClient mongoClient = new MongoClient( new ServerAddress( "ds023438.mlab.com", 23438));
        //MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://alex:jimenez@ds023438.mlab.com:23438/museosapp"));
        
        String user = "alex", 
               pass = "jimenez",
               host = "ds023438.mlab.com",
               ip = "23438",
               nameDB = "museosapp";
        
        System.out.println("Conectando con la base de dato de Mongo...");
        
        //String textUri = "mongodb://"+user+":"+pass+"@ds023438.mlab.com:"+ip+"/"+nameDB;
        String textUri = "mongodb://luis:conde@ds048878.mongolab.com:48878/MongoLab-l";
        //String textUri = "mongodb://alex:jimenez@ds023438.mlab.com/?authSource=museosapp&authMechanism=MONGODB-X509";
        MongoClientURI uri = new MongoClientURI(textUri);
        MongoClient mongoClient = new MongoClient(uri);
        
        String myUserName = "alex";
        //char[] myPassword = new char[] {'j', 'i', 'm', 'e', 'n', 'e', 'z'};
        String myPassword = "jimenez";
        
        // Now connect to your databases
         DB db = mongoClient.getDB( "MongoLab-l" );
         //DB db = mongoClient.getDB( "museosapp" );    //Versiones anteriores del JAR de Mongo.
         //MongoDatabase db = mongoClient.getDatabase("museosapp");   //Método nuevo para los JAR 3.X
         //mongoClient.getDatabase("museosapp")
         System.out.println("¡Conexión a la base de datos exitosamente!");
         System.out.println("Obteniendo colecciones de la base de datos...");
         /*boolean auth = db.authenticate(myUserName, myPassword.toCharArray());
         db.
         System.out.println("Authentication: "+auth);
         if (auth) {
            System.out.println("Successfully logged in to MongoDB!");
        } else {
            System.out.println("Invalid username/password");
        }*/
         
         //Listamos las bases de datos disponibles.
         /*List<String> dbs = mongoClient.getDatabaseNames();
            System.out.println("Bases de datos: ");
            System.out.println(dbs);
         */
         
         //Obtenemos todas las colecciones de la base de mongo
            Set<String> colls = db.getCollectionNames();
            
           System.out.println("Colecciones de la base de datos:"); 
           //Muestra las colecciones SIN el formato de JSON 
           /*for (String s : colls) {
           System.out.println(s);
           }*/
           //Muestra las colecciones CON el formato de JSON 
           System.out.println(colls);
           
        //Seleccionamos una colección en específico.
        DBCollection coleccion = db.getCollection("piezas");
        //Recuperamos todos los documentos de la colección seleccionada
        DBCursor cursor = coleccion.find();
        try {
            System.out.println("Documentos de la colección:\n");
           while (cursor.hasNext()) {
              DBObject cur = cursor.next();
              System.out.println(cur);
              
           }
           //Podemos contar el número de documentos en la colección.
              long count = coleccion.count();
              System.out.println("\nExisten: "+count+" colecciones.");
        } finally {
           cursor.close();
           mongoClient.close();
        }
        
         
//         DBCollection coleccion = db.getCollection("piezas");
//         System.out.println("Hasta aquí va bien");
//         
//         //Recuperamos un elemento (documento) de la colección.
//        DBObject documento = coleccion.findOne();
//        System.out.println( documento );

        /*Pieza pieza = createPieza();
        DBObject doc = createDBObject(pieza);

        //create museo
        WriteResult result = coleccion.insert(doc);
        System.out.println(result.getUpsertedId());
        System.out.println(result.getN());
        System.out.println(result.isUpdateOfExisting());
        //System.out.println(result.getLastConcern());
        
        //read example
        DBObject query = BasicDBObjectBuilder.start().add("id_pieza", pieza.getId_pieza()).get();
        DBCursor cursor2 = coleccion.find(query);
        //
        System.out.println("QUERY específico: ");
        while(cursor2.hasNext()){
            System.out.println(cursor2.next());
            mongoClient.close();
        }*/
        
        Create c = new Create();
        //c.createDocument();
        Read r = new Read();
        r.readDocumt();
        Update u = new Update();
        //u.updateDocument();
        Delete d = new Delete();
        //d.deleteDocument();
        
}//Fin del main
    
    
    private static DBObject createDBObject(Pieza pieza) {
            
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        
        docBuilder.append("nombre", pieza.getNombre());
        docBuilder.append("categoria", pieza.getCategoria());
        docBuilder.append("id_pieza", pieza.getId_pieza());
        docBuilder.append("autor", pieza.getAutor());
        docBuilder.append("ano", pieza.getAno());
        docBuilder.append("descripcion", pieza.getDescripcion());
        docBuilder.append("imagen", pieza.getImagen());
        return docBuilder.get();
        }
 
    private static Pieza createPieza() {
        Pieza p = new Pieza();
        p.setNombre("Prueba inserción");
        p.setCategoria("sin categoria");
        p.setId_pieza(6);
        p.setAutor("Nombre de un autor");
        p.setAno(1950);
        p.setDescripcion("Holi bb como has estado? Pa ke kieres saber eso?");
        p.setImagen("http://res.cloudinary.com/lconder/image/upload/v1440913055/sample.jpg");
        return p;
    }
}
    
