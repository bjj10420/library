

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 CAL 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
						







					/**최대, 최소 좌표 측정
					**/
					public static MinMaxCoor measureMinMaxCoor(List<? extends CoorComparable> list, MinMaxCoor coor) {
							MinMaxCoor ret = null;
					
							try {
								ret = new MinMaxCoor();
					
								double cameraYMax = 0, cameraYMin = 0;
								double cameraXMax = 0, cameraXMin = 0;
								int i = 0;
					
								if (coor != null) {
									// 전달 받은 좌표가 있는 경우
									cameraYMax = coor.cameraYMax;
									cameraYMin = coor.cameraYMin;
									cameraXMax = coor.cameraXMax;
									cameraXMin = coor.cameraXMin;
								} else {
									// 없으면 기본 좌표를 이용한다
									CoorComparable item = list.get(0);
									cameraYMax = item.getLat();
									cameraYMin = item.getLat();
									cameraXMax = item.getLng();
									cameraXMin = item.getLng();
					
									// 이미 첫번째 아이템을 사용했으므로 인덱스는 1부터
									i = 1;
								}
					
								// 루프를 순회하면서 최대값과 최소값을 구한다(X, Y)
								int size = list.size();
								for (; i < size; i++) {
									CoorComparable item = list.get(i);
					
									double lati = item.getLat();
									double longi = item.getLng();
					
									cameraYMax = Math.max(cameraYMax, lati);
									cameraYMin = Math.min(cameraYMin, lati);
									cameraXMax = Math.max(cameraXMax, longi);
									cameraXMin = Math.min(cameraXMin, longi);
								}
					
								ret.cameraYMax = cameraYMax;
								ret.cameraYMin = cameraYMin;
								ret.cameraXMax = cameraXMax;
								ret.cameraXMin = cameraXMin;
							} catch (Exception e) {
								CommonUtils.printDebugStackTrace(e);
							}
					
							return ret;
						}









					/**
					 * 해당 좌표가 모두 포함 되는 중앙 좌표와 줌레벨을 객체로 리턴 
					 */
					public ZoomInfo calculateZoomLevel(BPLineCommonMiddleMap middleMap, List<Item> items) {

							float x = middleMap.mSize.x;
							float y = middleMap.mSize.y;
							float zoomLevel = 19f; // 시작 줌레벨 19
							float scaleHorz = ((float) middleMap.mSize.x) / 500;
							float scaleVert = ((float) middleMap.mSize.y) / 960;

							// 화면 비율에 따른 줌레벨 조정(가로가 상대적으로 긴 경우)
							if (x / y >= 0.6f) {
								zoomLevel--;
							}

							double cameraYMax = 0, cameraYMin = 0, cameraXMax = 0, cameraXMin = 0;

							MinMaxCoor coor = null;

							// 리스트의 위치정보들을 입력
							Iterator it = items.listIterator();
							while (it.hasNext()) {

								BPLineBikeMetaItem item = (BPLineBikeMetaItem) it.next();

								LatLng itemLatLng = setDefaultBrandLocationByFixedValue(item.getTypeId());

								item.setLat(itemLatLng.latitude);
								item.setLng(itemLatLng.longitude);

								CommonUtils.printDebugLog("itemLat=" + item.getLat() + ",itemLng=" + item.getLng());

							}

							// 하나 이상의 출구 정보가 존재할 때는 출구가 모두 보이는 줌레벨과 포인트를 찾는다
							coor = CommonUtils.measureMinMaxCoor(items, null);

							if (coor != null) {
								cameraXMax = coor.cameraXMax;
								cameraXMin = coor.cameraXMin;
								cameraYMax = coor.cameraYMax;
								cameraYMin = coor.cameraYMin;
							}

							int mapWidth = 0;
							int mapHeight = 0;

							View mMiddleMapLayout = middleMap.getmMiddleMapLayout();

							if (mMiddleMapLayout != null) {
								mapWidth = mMiddleMapLayout.getMeasuredWidth();
								mapHeight = mMiddleMapLayout.getMeasuredHeight();

								float horScale = (scaleHorz > 1.0f) ? scaleHorz : 1;
								mapWidth = (int) (516f * horScale);
								// mapWidth = (int) (150f * horScale);

								// mapWidth = size.x;

								float vertScale = (scaleVert > 1.0f) ? scaleVert : 1;
								mapHeight = (int) (300f * vertScale);
								// mapHeight = (int) (230f * scale);

								// mapHeight = size.y;

							}

							// 출구 좌표의 최대, 최소 지점을 이용해서 수평, 수직, 대각선 거리를 구한다
							// 그 거리에 따라서 줌 레벨을 설정한다
							double distHorizontal = latitudeLongitudeToDistance(cameraYMin, cameraYMin, cameraXMax,
									cameraXMin);

							double distVertical = latitudeLongitudeToDistance(cameraYMin, cameraYMax, cameraXMin, cameraXMin);

							float zoomLevelHorizontal = calculateZoomLevel(distHorizontal, mapWidth, scaleHorz, -1);
							float zoomLevelVertical = calculateZoomLevel(distVertical, mapHeight, scaleVert, -1);
							
							zoomLevel = Math.min(zoomLevelHorizontal, zoomLevelVertical);
							middleMap.mOldZoomLevel = zoomLevel;

							ZoomInfo ret = new ZoomInfo();
							ret.zoom = zoomLevel;
							ret.latitude = (cameraYMax + cameraYMin) / 2;
							ret.longitude = (cameraXMax + cameraXMin) / 2;
							return ret;
						}		
					









						/*************************************************************************************
						 * latitudeLongitudeToDistance: 주어진 위도 경도를 이용해서 두 점 사이의 거리를 측정(단위는 km)
						 * @작성자 : Hwang Inho(mmuse1230@gmail.com)
						 * @작성일 : 2015. 10. 6.
						 * @param lat1
						 * @param lat2
						 * @param lon1
						 * @param lon2
						 * @return 
						 * @수정이력
						 *  1. ...
						 */
						public double latitudeLongitudeToDistance(double lat1, double lat2, double lon1, double lon2)
						{
							double theta = 0, dist = 0;
							
							try {			
								theta = lon1 - lon2;

								dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
										* Math.cos(deg2rad(theta));
								dist = Math.acos(dist);
								dist = rad2deg(dist);
								dist = dist * 60 * 1.1515; // statute miles. 단위는 기본 마일.
								dist = dist * 1.609344;
							} catch (Exception e) {
								CommonUtils.printDebugStackTrace(e);
							}
							

							return dist;
						}









							// 줌 레벨 계산
							private float calculateZoomLevel(double dist, int measuredLength, float scale, float startZoomLevel) {
							// 줌 레벨에 대한 내용은 아래 링크를 참조:
							// http://www.androidside.com/bbs/board.php?bo_table=B49&wr_id=50224

							float baseZoomDistInPx = 0.306f; // zoom level = 16일 때 1픽셀의 거리(km)

							if (startZoomLevel < 0) {
								startZoomLevel = 16; // 기본 줌 레벨은 16
							} else {
								if (startZoomLevel == 17) {
									baseZoomDistInPx = 0.153f;
								} else if (startZoomLevel == 18) {
									baseZoomDistInPx = 0.076f;
								} else if (startZoomLevel == 19) {
									baseZoomDistInPx = 0.038f;
								} else if (startZoomLevel >= 20) {
									// 19보다 큰 줌 레벨은 오류
									return -1;
								}
							}

							double distInPixel = (dist / baseZoomDistInPx) * (1.5 * 90 * scale);

							while (distInPixel > measuredLength - (90 * scale)) {
								startZoomLevel -= 0.2f;
								baseZoomDistInPx *= 1.14869835f;

								distInPixel = (dist / baseZoomDistInPx) * (1.5 * 90 * scale);

								if (startZoomLevel <= 0) {
									return 1;
								}
							}

							startZoomLevel--;

							if (startZoomLevel <= 0) {
								return 1;
							} else {
								return startZoomLevel;
							}
						}










					}
