package com.java.custom.collection;

public class CustomHashMap<K, V> {
	private CustomEntry<K, V>[] table;
	private int CAPACITY = 4;

	@SuppressWarnings("unchecked")
	public CustomHashMap() {
		this.table = new CustomEntry[CAPACITY];
	}
	public void put(K newKey, V data){
	       if(newKey==null)
	           return;    //does not allow to store null.
	      
	       int hash=hash(newKey);
	       CustomEntry<K,V> newEntry = new CustomEntry<K,V>(newKey, data, null);
	      
	        if(table[hash] == null){
	         table[hash] = newEntry;
	        }else{
	        	CustomEntry<K,V> previous = null;
	        	CustomEntry<K,V> current = table[hash];
	           
	           while(current != null){ //we have reached last entry of bucket.
	           if(current.key.equals(newKey)){                  
	               if(previous==null){  //node has to be insert on first of bucket.
	                     newEntry.next=current.next;
	                     table[hash]=newEntry;
	                     return;
	               }
	               else{
	               newEntry.next=current.next;
	               previous.next=newEntry;
	               return;
	               }
	           }
	           previous=current;
	             current = current.next;
	         }
	         previous.next = newEntry;
	        }
	    }
	   public V get(K key){
	        int hash = hash(key);
	        if(table[hash] == null){
	         return null;
	        }else{
	        	CustomEntry<K,V> temp = table[hash];
	         while(temp!= null){
	             if(temp.key.equals(key))
	                 return temp.value;
	             temp = temp.next; //return value corresponding to key.
	         }         
	         return null;   //returns null if key is not found.
	        }
	    }
	   
	   public boolean remove(K deleteKey){
	       
	       int hash=hash(deleteKey);
	              
	      if(table[hash] == null){
	            return false;
	      }else{
	    	  CustomEntry<K,V> previous = null;
	    	  CustomEntry<K,V> current = table[hash];
	        
	        while(current != null){ //we have reached last entry node of bucket.
	           if(current.key.equals(deleteKey)){               
	               if(previous==null){  //delete first entry node.
	                     table[hash]=table[hash].next;
	                     return true;
	               }
	               else{
	                     previous.next=current.next;
	                   return true;
	               }
	           }
	           previous=current;
	             current = current.next;
	          }
	        return false;
	      }
	    
	    }
	   
	private int hash(K key)
	{
		return  Math.abs(key.hashCode())%CAPACITY;
	}

	static class CustomEntry<K, V> {
		K key;
		V value;
		CustomEntry<K, V> next;

		public CustomEntry(K key, V value, CustomEntry<K,V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

	}
}
