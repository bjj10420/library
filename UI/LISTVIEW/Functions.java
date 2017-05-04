

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 LISTVIEW 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
						






					/**
					 * 필터된 목록에서 이름으로 리스트내 해당 포지션을 리턴
					 * @return
					 */
					public int getPositionByName(String stationName) {
						
						int position = 0;
						
						for(BPLineRailDestStation station : List) {
							
							if(station.getStationName().equals(stationName)) return position;
							
							position++;
						}
						
						return position;
					}












		
					}
