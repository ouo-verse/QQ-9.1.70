package xx2;

import android.annotation.SuppressLint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.view.QFSTVideoSeekBar;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 >2\u00020\u0001:\u0002\u0012\u0018B'\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u00a2\u0006\u0004\bM\u0010NJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010!\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\"\u00106\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010)\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010:\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010)\u001a\u0004\b8\u00103\"\u0004\b9\u00105R\u0017\u0010@\u001a\u00020;8\u0006\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0017\u0010B\u001a\u00020;8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010=\u001a\u0004\bA\u0010?R\u0017\u0010G\u001a\u00020C8\u0006\u00a2\u0006\f\n\u0004\b8\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010L\u001a\u00020H8\u0006\u00a2\u0006\f\n\u0004\b2\u0010I\u001a\u0004\bJ\u0010K\u00a8\u0006O"}, d2 = {"Lxx2/b;", "", "", Element.ELEMENT_NAME_DISTANCE, "", "r", ReportConstant.COSTREPORT_PREFIX, "t", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "getFullScreenContainer", "()Landroid/view/ViewGroup;", "fullScreenContainer", "b", "getVideoContainer", "videoContainer", "Lcom/tencent/mobileqq/tvideo/view/QFSTVideoSeekBar;", "c", "Lcom/tencent/mobileqq/tvideo/view/QFSTVideoSeekBar;", "getSeekBar", "()Lcom/tencent/mobileqq/tvideo/view/QFSTVideoSeekBar;", "seekBar", "Lxx2/b$d;", "d", "Lxx2/b$d;", DomainData.DOMAIN_NAME, "()Lxx2/b$d;", "callback", "e", "getCurrentSeekBar", "u", "(Lcom/tencent/mobileqq/tvideo/view/QFSTVideoSeekBar;)V", "currentSeekBar", "f", UserInfo.SEX_FEMALE, "totalDistanceX", "g", "totalDistanceY", "", h.F, "Z", "scrollHorizontal", "i", "scrollVertical", "", "j", "I", "posBeforeScroll", "k", "p", "()Z", "w", "(Z)V", "scrollDisable", "l", "o", "v", "interceptScroll", "Landroid/view/GestureDetector;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/GestureDetector;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/view/GestureDetector;", "videoDetector", "getFullScreenDetector", "fullScreenDetector", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "getVideoGestureListener", "()Landroid/view/GestureDetector$OnGestureListener;", "videoGestureListener", "Landroid/view/GestureDetector$OnDoubleTapListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "getOnDoubleTapListener", "()Landroid/view/GestureDetector$OnDoubleTapListener;", "onDoubleTapListener", "<init>", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup;Lcom/tencent/mobileqq/tvideo/view/QFSTVideoSeekBar;Lxx2/b$d;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes19.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup fullScreenContainer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup videoContainer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QFSTVideoSeekBar seekBar;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d callback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QFSTVideoSeekBar currentSeekBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float totalDistanceX;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float totalDistanceY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean scrollHorizontal;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean scrollVertical;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int posBeforeScroll;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean scrollDisable;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean interceptScroll;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GestureDetector videoDetector;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GestureDetector fullScreenDetector;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GestureDetector.OnGestureListener videoGestureListener;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GestureDetector.OnDoubleTapListener onDoubleTapListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"xx2/b$b", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xx2.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class ViewOnTouchListenerC11575b implements View.OnTouchListener {
        ViewOnTouchListenerC11575b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
            Integer num;
            QLog.d("TVideoPlayerGesture", 4, "videoContainer onTouch");
            if (!b.this.getInterceptScroll()) {
                return false;
            }
            if (b.this.getScrollDisable()) {
                return true;
            }
            if (event != null) {
                num = Integer.valueOf(event.getAction() & 255);
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 1) {
                if (b.this.scrollHorizontal) {
                    b.this.t();
                }
                b.this.scrollHorizontal = false;
                b.this.scrollVertical = false;
            }
            return b.this.getVideoDetector().onTouchEvent(event);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J#\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lxx2/b$d;", "", "", "onSingleTap", "", HippyTKDListViewAdapter.X, "y", "a", "(Ljava/lang/Float;Ljava/lang/Float;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public interface d {
        void a(@Nullable Float x16, @Nullable Float y16);

        void onSingleTap();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"xx2/b$e", "Landroid/view/GestureDetector$OnDoubleTapListener;", "Landroid/view/MotionEvent;", "p0", "", "onSingleTapConfirmed", "onDoubleTap", "onDoubleTapEvent", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class e implements GestureDetector.OnDoubleTapListener {
        e() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(@Nullable MotionEvent p06) {
            if (p06 == null) {
                return true;
            }
            b.this.getCallback().a(Float.valueOf(p06.getRawX()), Float.valueOf(p06.getRawY()));
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(@Nullable MotionEvent p06) {
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(@Nullable MotionEvent p06) {
            b.this.getCallback().onSingleTap();
            return true;
        }
    }

    public b(@NotNull ViewGroup fullScreenContainer, @NotNull ViewGroup videoContainer, @NotNull QFSTVideoSeekBar seekBar, @NotNull d callback) {
        Intrinsics.checkNotNullParameter(fullScreenContainer, "fullScreenContainer");
        Intrinsics.checkNotNullParameter(videoContainer, "videoContainer");
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.fullScreenContainer = fullScreenContainer;
        this.videoContainer = videoContainer;
        this.seekBar = seekBar;
        this.callback = callback;
        this.currentSeekBar = seekBar;
        this.interceptScroll = true;
        f fVar = new f();
        this.videoGestureListener = fVar;
        e eVar = new e();
        this.onDoubleTapListener = eVar;
        GestureDetector gestureDetector = new GestureDetector(videoContainer.getContext(), fVar);
        this.videoDetector = gestureDetector;
        gestureDetector.setOnDoubleTapListener(eVar);
        GestureDetector gestureDetector2 = new GestureDetector(fullScreenContainer.getContext(), new a());
        this.fullScreenDetector = gestureDetector2;
        gestureDetector2.setOnDoubleTapListener(eVar);
        videoContainer.setOnTouchListener(new ViewOnTouchListenerC11575b());
        fullScreenContainer.setOnTouchListener(new View.OnTouchListener() { // from class: xx2.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean b16;
                b16 = b.b(b.this, view, motionEvent);
                return b16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(b this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.fullScreenDetector.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(float distance) {
        int width = this.videoContainer.getWidth();
        int u16 = this.currentSeekBar.u();
        if (u16 != 0 && width != 0) {
            int v3 = this.currentSeekBar.v();
            if ((v3 >= u16 && distance < 0.0f) || (v3 <= 0 && distance > 0.0f)) {
                this.totalDistanceX -= distance;
            }
            this.currentSeekBar.A(Math.min(Math.max(this.posBeforeScroll + ((int) (((-this.totalDistanceX) * u16) / width)), 0), u16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        this.posBeforeScroll = this.currentSeekBar.v();
        this.videoContainer.requestDisallowInterceptTouchEvent(true);
        this.currentSeekBar.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        this.videoContainer.requestDisallowInterceptTouchEvent(false);
        this.currentSeekBar.C();
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final d getCallback() {
        return this.callback;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getInterceptScroll() {
        return this.interceptScroll;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getScrollDisable() {
        return this.scrollDisable;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final GestureDetector getVideoDetector() {
        return this.videoDetector;
    }

    public final void u(@NotNull QFSTVideoSeekBar qFSTVideoSeekBar) {
        Intrinsics.checkNotNullParameter(qFSTVideoSeekBar, "<set-?>");
        this.currentSeekBar = qFSTVideoSeekBar;
    }

    public final void v(boolean z16) {
        this.interceptScroll = z16;
    }

    public final void w(boolean z16) {
        this.scrollDisable = z16;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016\u00a8\u0006\u0012"}, d2 = {"xx2/b$a", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/MotionEvent;", "p0", "", "onDown", "", "onShowPress", "onSingleTapUp", "p1", "", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, e.a.NAME, "p2", "p3", "onFling", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements GestureDetector.OnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(@Nullable MotionEvent p06) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent p06, @Nullable MotionEvent p16, float p26, float p36) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@Nullable MotionEvent p06, @Nullable MotionEvent p16, float distanceX, float distanceY) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@Nullable MotionEvent p06) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(@Nullable MotionEvent p06) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(@Nullable MotionEvent p06) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016\u00a8\u0006\u0012"}, d2 = {"xx2/b$f", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/MotionEvent;", "p0", "", "onDown", "", "onShowPress", "onSingleTapUp", "p1", "", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, e.a.NAME, "p2", "p3", "onFling", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class f implements GestureDetector.OnGestureListener {
        f() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(@Nullable MotionEvent p06) {
            b.this.totalDistanceX = 0.0f;
            b.this.totalDistanceY = 0.0f;
            b.this.scrollHorizontal = false;
            b.this.scrollVertical = false;
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent p06, @Nullable MotionEvent p16, float p26, float p36) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@Nullable MotionEvent p06, @Nullable MotionEvent p16, float distanceX, float distanceY) {
            QLog.d("TVideoPlayerGesture", 4, "videoGestureListener onScroll");
            if (!b.this.getInterceptScroll()) {
                return false;
            }
            if (b.this.getScrollDisable()) {
                return true;
            }
            b.this.totalDistanceX += distanceX;
            b.this.totalDistanceY += distanceY;
            if (!b.this.scrollHorizontal && !b.this.scrollVertical) {
                if (Math.abs(b.this.totalDistanceX) > 10.0f) {
                    b.this.scrollHorizontal = true;
                    b.this.s();
                } else if (Math.abs(b.this.totalDistanceY) > 10.0f) {
                    b.this.scrollVertical = true;
                }
            } else if (b.this.scrollHorizontal) {
                b.this.r(distanceX);
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@Nullable MotionEvent p06) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(@Nullable MotionEvent p06) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(@Nullable MotionEvent p06) {
        }
    }
}
