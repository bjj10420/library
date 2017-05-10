

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 HASHMAP 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
						








	
						/**
						 * 가지고 있는 맵을 가지고 리스트를 만들어 반환하여 준다
						 * @param <T>
						 */
						public static <T> ArrayList<T> convertMapToList(HashMap<T,T> dataMap) {
							
							ArrayList<T> list = new ArrayList<T>();
							
							for(T key : dataMap.keySet()) {
								
								list.add(dataMap.get(key));
								
							}
							
							return list;
							
						}
					}
