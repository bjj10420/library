

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 SCROLLVIEW 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
		



		





						/**
						 * 스크롤뷰의 특정 자식뷰쪽으로 스크롤
						 *
						 * @param scrollViewParent Parent ScrollView
						 * @param view View to which we need to scroll.
						 */
						public static void scrollToView(final HorizontalScrollView scrollViewParent, final View view) {
						    // Get deepChild Offset
						    Point childOffset = new Point();
						    getDeepChildOffset(scrollViewParent, view.getParent(), view, childOffset);
						    // Scroll to child.
						    scrollViewParent.smoothScrollTo(childOffset.x, 0);
						}











						/**
						 * Used to get deep child offset.
						 * <p/>
						 * 1. We need to scroll to child in scrollview, but the child may not the direct child to scrollview.
						 * 2. So to get correct child position to scroll, we need to iterate through all of its parent views till the main parent.
						 *
						 * @param mainParent        Main Top parent.
						 * @param parent            Parent.
						 * @param child             Child.
						 * @param accumulatedOffset Accumalated Offset.
						 */
						public static void getDeepChildOffset(final ViewGroup mainParent, final ViewParent parent, final View child, final Point accumulatedOffset) {
						    ViewGroup parentGroup = (ViewGroup) parent;
						    accumulatedOffset.x += child.getLeft();
						    accumulatedOffset.y += child.getTop();
						    if (parentGroup.equals(mainParent)) {
						        return;
						    }
						    getDeepChildOffset(mainParent, parentGroup.getParent(), parentGroup, accumulatedOffset);
						}

						
					}
