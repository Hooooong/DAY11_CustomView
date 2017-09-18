Android Programing
----------------------------------------------------
#### 2017.09.18 5일차

###### 예제
____________________________________________________

###### 공부정리
____________________________________________________

  - CustomWidget

      ![CustomWidget](https://github.com/Hooooong/DAY11_CustomView/blob/master/image/CustomWidget.png)

      - CustomWidget 생성 방법

          1. Custom 속성을 attrs.xml( attrs : attributes 의 약자 ) 파일에 정의
          2. Custom 할 객체(Widget)를 상속받은 후 재정의
          3. Custom 할 객체(Widget)를 Layout.xml 에 Tag 로 사용
          4. CustomWidget 에서 동작 처리 및 activity 에서 동작 처리

              ```Java
              // 1. attrs.xml 에 정의된 속성을 가져온다.
              TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AniButton);
              // 2. 해당 이름으로 정의된 속성의 갯수를 가져온다.
              int size = typedArray.getIndexCount();
              // 3. 반복문을 돌면서 해당 속성에 대한 처리를 해준다.
              for (int i = 0; i < size; i++) {
                  // 3-1. 현재 배열에 있는 속성 ID 를 가져오기
                  int currentAttr = typedArray.getIndex(i);
                  // 3-2. ID 값마다 switch-case 처리
                  switch (currentAttr) {
                      case R.styleable.AniButton_animation:
                        break;
                  }
              }          
              ```

      - CustomWidget 코드

          - xml 코드

              - attrs.xml

              ```xml
              <?xml version="1.0" encoding="utf-8"?>
              <resources>
                  <!-- 재정의할 객체 이름 -->
                  <declare-styleable name="AniButton">
                      <!-- format 은 String, Resource 2가지만 된다.-->
                      <attr name="animation" format="string"/>
                      <attr name="animation_name" format="string"/>
                  </declare-styleable>
              </resources>
              ```

              - activity_main.xml

              ```xml
              <!-- xmlns:custom="http://schemas.android.com/apk/res-auto" : nameSpace 를 자동으로 지원(custom) -->
              <!-- custom:"attrs.xml 에 정의된 attr 명시" = "value" -->
              <hooooong.com.customview.AniButton
                  xmlns:custom="http://schemas.android.com/apk/res-auto"
                  android:id="@+id/aniButton"
                  custom:animation="true"
                  android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  android:text="Hello CustomWidget" />
              ```

          - java 코드

              - AniButton.java ( CustomWidget 작성 코드 )

              ```java
              // Button 을 상속받아도 되지만
              // android.support.v7.widget.AppCompatButton 을 상속받아
              // 하위버전에도 Material Design 이 적용된 Button 을 사용하게 한다.              
              public class AniButton extends AppCompatButton{

                /**
                 * SourceCode 에서 생성할 때 사용하는 생성자
                 *
                 * @param context
                 */
                public AniButton(Context context){
                    super(context);
                }

                /**
                 * xml 에서 Tag 로 사용할 때 시스템에서 호출해주는 생성자
                 * View 를 xml 에 넣기 때문에 AttributeSet 이 있어야 한다.
                 * ( 3, 4 번째 매개변수는 테마 관련 변수이다.)
                 *
                 * @param context
                 * @param attrs
                 */              
                public AniButton(final Context context, AttributeSet attrs) {
                    super(context, attrs);

                    // 1. attrs.xml 에 정의된 속성을 가져온다.
                    TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AniButton);

                    // 2. 해당 이름으로 정의된 속성의 갯수를 가져온다.
                    int size = typedArray.getIndexCount();

                    // 3. 반복문을 돌면서 해당 속성에 대한 처리를 해준다.
                    for (int i = 0; i < size; i++) {
                        // 3-1. 현재 배열에 있는 속성 ID 를 가져오기
                        int currentAttr = typedArray.getIndex(i);
                        // 3-2. ID 값마다 switch-case 처리
                        switch (currentAttr) {
                            case R.styleable.AniButton_animation:
                                String animation = typedArray.getString(currentAttr);
                                if("true".eqauls(animation)){
                                  // true 일 때 조건 처리
                                }else{
                                  // false 일 때 조건 처리
                                }
                                break;
                        }
                    }

                }
              }
              ```

              - MainActivity.java

                  ```java
                  // 1. CustomWidget Class 를 생성한다.
                  AniButton aniButton;  
                  // 2. findViewById로 MainActivity와 xml 을 연결해준다.
                  aniButton = (AniButton)findViewById(R.id.aniButton);

                  aniButton.setOnClickListener(new View.OnClickListener(){
                      @Override
                      public void onClick(View v) {
                          //... 다른 Widget 과 동일하게 사용
                      }
                  });   
                  ```

  - CustomView

      - CustomView 생성 방법

          1. Custom 할 View를 상속받은 후 onDraw 재정의
          2. Custom 할 View를 Layout.xml 에 Tag 로 사용

      - CustomView 코드

          - xml 코드

              - activity_main.xml

              ```xml
              <hooooong.com.customview.CustomView
                  android:layout_width="300dp"
                  android:layout_height="200dp"
                  />

              ```

          - java 코드

              - CustomView.java

              ```java
              // View를 상속받아 생성
              public class CustomView extends View {

                  /**
                   * SourceCode 에서 생성할 때 사용하는 생성자
                   *
                   * @param context
                   */
                  public CustomView(Context context){
                      super(context);
                  }

                  /**
                   * xml 에서 Tag 로 사용할 때 시스템에서 호출해주는 생성자
                   * View 를 xml 에 넣기 때문에 AttributeSet 이 있어야 한다.
                   * ( 3, 4 번째 매개변수는 테마 관련 변수이다.)
                   *
                   * @param context
                   * @param attrs
                   */
                  public CustomView(Context context, @Nullable AttributeSet attrs) {
                      super(context, attrs);
                  }

                  /**
                   * View 그리기
                   *
                   * @param canvas
                   */
                  @Override
                  protected void onDraw(Canvas canvas) {
                      super.onDraw(canvas);

                      /**
                       * 사각형 그리기
                       */
                      // 물감 - 겉 모양을 결정하는 도구(색, 두께 정하기)
                      Paint paint = new Paint();
                      paint.setColor(Color.MAGENTA);

                      // canvas : 붓으로 그려지는 도화지(화면)
                      // drawRect : 붓
                      canvas.drawRect(100, 100, 200, 200, paint);
                  }
              }
              ```

              - MainActivity.java

                  ```java
                  // 1. CustomView Class 를 생성한다.
                  CustomView customView;  
                  // 2. findViewById로 MainActivity와 xml 을 연결해준다.
                  customView = (CustomView)findViewById(R.id.customView);

                  // ... 동일하게 사용

                  // OR
                  // xml 로 생성하지 않고 직접 생성하여 사용
                  CustomView cv = new CustomView(this);
                  cv.setX(300);
                  cv.setY(300);
                  stage.addView(cv);                  

                  ```
