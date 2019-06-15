package lucene;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import domain.Resultado;

import org.apache.lucene.analysis.br.BrazilianAnalyzer;

import org.apache.lucene.document.*;
import org.apache.lucene.document.Field.Store;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class Recomendacao {    
	
	 
	
  public  static void indexDirectory() {
         try {           
         Path path = Paths.get("/kdmeufilme.com.br/indice");
         Directory directory = FSDirectory.open(path);
         IndexWriterConfig config = new IndexWriterConfig(new BrazilianAnalyzer());        
         IndexWriter indexWriter = new IndexWriter(directory, config);
         indexWriter.deleteAll();
         File f = new File("/kdmeufilme.com.br/legendas"); // current directory     
             for (File file : f.listFiles()) {
                    System.out.println("Indexando o arquivo - " + file.getCanonicalPath());               
                    Document doc = new Document();
                    doc.add(new TextField("path", file.getName(), Store.YES));
                    FileInputStream is = new FileInputStream(file);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    StringBuffer stringBuffer = new StringBuffer();
                    String line = null;
                    while((line = reader.readLine())!=null){
                      stringBuffer.append(line).append("\n");
                    }
                    reader.close();
                    doc.add(new TextField("contents", stringBuffer.toString(), Store.YES));
                    indexWriter.addDocument(doc);      
                    
             }      
             indexWriter.commit();
             indexWriter.close();           
             directory.close();
        } catch (Exception e) { e.printStackTrace(); }                   
    }     
   public static List<Resultado> search(String text) { 
	   System.out.println("galo");
	   List<Resultado> resultado = new ArrayList<Resultado>();
	   System.out.println("galo2");
        try {   
        	System.out.println("galo3");
            Path path = Paths.get("/kdmeufilme.com.br/indice");
            System.out.println("galo4");
            System.out.println("galo5");
            System.out.println(path);
            System.out.println("galo6");
            Directory directory = FSDirectory.open(path);       
            IndexReader indexReader =  DirectoryReader.open(directory);
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);
            QueryParser queryParser = new QueryParser("contents",  new BrazilianAnalyzer());  
            Query query = queryParser.parse(text);
            TopDocs topDocs = indexSearcher.search(query,100);
            System.out.println("totalHits " + topDocs.totalHits);            
           // int cont=0;
            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {           
               Document document = indexSearcher.doc(scoreDoc.doc);
              // System.out.println("INFO BUSCADOR - Caminho:" + document.get("path") + " - Score: " + scoreDoc.score);
               resultado.add(new Resultado(document.get("path"), scoreDoc.score));
//               vetor[cont]="INFO BUSCADOR - Caminho:" + document.get("path") + " - Score: " + scoreDoc.score;                
                //cont++;
            }            
        } catch (Exception e) { e.printStackTrace(); }
        
		return (resultado);               
    }
   
   public static List<Resultado> searchsemelhante(String text) { 
	   System.out.println("galo");
	   List<Resultado> resultado = new ArrayList<Resultado>();        
        try {   
            Path path = Paths.get("/kdmeufilme.com.br/indice");
            Directory directory = FSDirectory.open(path);       
            IndexReader indexReader =  DirectoryReader.open(directory);
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);
            QueryParser queryParser = new QueryParser("contents",  new BrazilianAnalyzer());  
            Query query = queryParser.parse(text);
            TopDocs topDocs = indexSearcher.search(query,50);
            System.out.println("totalHits " + topDocs.totalHits);            
           // int cont=0;
            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {           
               Document document = indexSearcher.doc(scoreDoc.doc);
              // System.out.println("INFO BUSCADOR - Caminho:" + document.get("path") + " - Score: " + scoreDoc.score);
               resultado.add(new Resultado(document.get("path"), scoreDoc.score));
//               vetor[cont]="INFO BUSCADOR - Caminho:" + document.get("path") + " - Score: " + scoreDoc.score;                
                //cont++;
            }            
        } catch (Exception e) { e.printStackTrace(); }
        
		return (resultado);               
    }
   
  
   
   
   public static String[] searchrecomendation() { 
	  // System.out.println("galo2");
	  
	   try {   
           Path path = Paths.get("/kdmeufilme.com.br/indice");
           Directory directory = FSDirectory.open(path);       
           IndexReader indexReader =  DirectoryReader.open(directory);
           IndexSearcher indexSearcher = new IndexSearcher(indexReader);
           //QueryParser queryParser = new QueryParser("contents",  new BrazilianAnalyzer());  
           //Query query = queryParser.parse(text);
           //TopDocs topDocs = indexSearcher.search();
           Query query = new MatchAllDocsQuery();
           TopDocs topDocs = indexSearcher.search(query,1000);
           //TopDocs topDocs = 
           String vetor[] = new String[topDocs.totalHits];
           
           //System.out.println("totalHits " + topDocs.totalHits);            
           int cont=0;
           for (ScoreDoc scoreDoc : topDocs.scoreDocs) {           
              Document document = indexSearcher.doc(scoreDoc.doc);
             // System.out.println("INFO BUSCADOR - Caminho:" + document.get("path") + " - Score: " + scoreDoc.score);
              //if (text.contains(document.get("path"))){
            	//  System.out.println("Filme achado!");
            	  //vetor = "OK";
//            	  break;
  //            }
              
             vetor[cont]= cont + document.get("path") + " - Score: " + scoreDoc.score;                
             cont++;
           }
           System.out.println("Sucesso");
           return (vetor);
           
       } catch (Exception e) { e.printStackTrace(); }                  
	   System.out.println("ERRO");
	   return null;
	   
    }
   
   
   
   
   
   
  }