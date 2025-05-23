package z50;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.widgets.multitouchimg.QCircleMultiTouchImageView;
import com.tencent.biz.qqcircle.widgets.multitouchimg.l;
import com.tencent.biz.qqcircle.widgets.multitouchimg.o;
import com.tencent.biz.richframework.animation.transition.TransitionDragLayout;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends u implements View.OnClickListener, o {

    /* renamed from: d, reason: collision with root package name */
    private View f451948d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f451949e;

    /* renamed from: f, reason: collision with root package name */
    private QCircleMultiTouchImageView f451950f;

    /* renamed from: h, reason: collision with root package name */
    private View f451951h;

    /* renamed from: i, reason: collision with root package name */
    private TransitionDragLayout f451952i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f451953m = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void F9() {
        QLog.d(getTAG(), 1, "[handleClose]");
        if (getActivity() != null) {
            getActivity().finish();
            getActivity().overridePendingTransition(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G9() {
        this.f451948d.setBackgroundColor(0);
        this.f451949e.setVisibility(8);
        this.f451951h.setAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean H9(MotionEvent motionEvent, float f16, float f17) {
        QCircleMultiTouchImageView qCircleMultiTouchImageView = this.f451950f;
        if (qCircleMultiTouchImageView != null && Math.abs(qCircleMultiTouchImageView.getScale() - 1.0f) > 0.001f) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I9(float f16) {
        QCircleMultiTouchImageView qCircleMultiTouchImageView = this.f451950f;
        if (qCircleMultiTouchImageView != null) {
            qCircleMultiTouchImageView.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J9() {
        this.f451948d.setBackgroundColor(-16777216);
        this.f451949e.setVisibility(0);
        this.f451951h.setAlpha(1.0f);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSAvatarLayerExitPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            F9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f451948d = view.findViewById(R.id.f34010y0);
        this.f451950f = (QCircleMultiTouchImageView) view.findViewById(R.id.f33920xr);
        this.f451949e = (ImageView) view.findViewById(R.id.f33930xs);
        this.f451951h = view.findViewById(R.id.f33960xv);
        this.f451948d.setOnClickListener(this);
        this.f451949e.setOnClickListener(this);
        TransitionDragLayout transitionDragLayout = (TransitionDragLayout) view.findViewById(R.id.f34000xz);
        this.f451952i = transitionDragLayout;
        transitionDragLayout.setFeatureEnable(true);
        this.f451952i.setEnableDragHorizontal(true);
        this.f451952i.setEnableDragVertical(true);
        this.f451952i.setOnDragListener(new a());
        this.f451952i.setDragInterceptDelegate(new TransitionDragLayout.DragInterceptDelegate() { // from class: z50.b
            @Override // com.tencent.biz.richframework.animation.transition.TransitionDragLayout.DragInterceptDelegate
            public final boolean needIntercept(MotionEvent motionEvent, float f16, float f17) {
                boolean H9;
                H9 = d.this.H9(motionEvent, f16, f17);
                return H9;
            }
        });
        this.f451950f.setOnScaleEndListener(new l() { // from class: z50.c
            @Override // com.tencent.biz.qqcircle.widgets.multitouchimg.l
            public final void onScaleEnd(float f16) {
                d.this.I9(f16);
            }
        });
        this.f451950f.setOnViewTapListener(this);
        this.f451948d.setBackgroundColor(-16777216);
    }

    @Override // com.tencent.biz.qqcircle.widgets.multitouchimg.o
    public void onViewTap(View view, float f16, float f17) {
        if (view == null) {
            return;
        }
        F9();
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements TransitionDragLayout.OnDragListener {
        a() {
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionDragLayout.OnDragListener
        public void onDragging() {
            if (!d.this.f451953m) {
                d.this.G9();
                d.this.f451953m = true;
            }
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionDragLayout.OnDragListener
        public void onEndDrag(boolean z16) {
            if (z16) {
                d.this.F9();
            } else {
                d.this.J9();
            }
            d.this.f451953m = false;
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionDragLayout.OnDragListener
        public void onStartDrag() {
        }
    }
}
