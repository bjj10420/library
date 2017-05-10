

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 CLASS 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
						








						/**
						 * 클래스에서 필드이름을 찾아서 값을 반환
						 *
						 * @LastModifyDate : 2017. 1. 19.
						 * @LastModifier : JJBAE
						 * @LastVersion : 1.0 2017. 1. 19. JJBAE
						 * @param fieldName
						 * @return
						 */
						public String getValueFromField(Class<?> cls, String fieldName) {
							CommonUtils.printDebugLog("GuideManager getValueFromField");
					
							String value = "";
							try {
					
								Field field = cls.getDeclaredField(fieldName);
								value = (String) field.get(this);
					
							} catch (Exception e) {
					
								e.printStackTrace();
					
							}
					
							return value;
						}










						/**
						 * 상수 클래스에서 모든 필드를 가지고 오는 함수 *
						 * 
						 * @LastModifyDate : 2017. 01. 19
						 * @LastModifier : JJBAE
						 * @LastVersion : 1.0 2017. 01. 19. JJBAE
						 * @return
						 */
						public List<Field> getAllFieldsFromClass(Class cls) {
							CommonUtils.printDebugLog("GuideManager getAllFieldsFromClass");
					
							List<Field> privateFields = new ArrayList<Field>();
							Field[] allFields = cls.getDeclaredFields();
					
							for (Field field : allFields) {
					
								privateFields.add(field);
					
							}
					
							return privateFields;
					
						}









					}
