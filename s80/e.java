package s80;

import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.af;
import com.tencent.biz.qqcircle.immersive.gallery.view.QFSGalleryProgressViewNoAnim;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends s80.b implements QFSImageBanner.c {
    private View U;
    private QFSImageBanner V;
    private p80.e W;
    private QFSGalleryProgressViewNoAnim X;
    private TextView Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f433449a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f433450b0;

    /* renamed from: c0, reason: collision with root package name */
    private final af f433451c0 = new af();

    /* renamed from: d0, reason: collision with root package name */
    private boolean f433452d0;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            if (i3 == e.this.Z) {
                return;
            }
            e eVar = e.this;
            eVar.P.R1(((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) eVar).f85017h).f398449id.get(), i3);
            e.this.Z = i3;
            e.this.f433451c0.f86143a = i3;
            e eVar2 = e.this;
            eVar2.T0(eVar2.f433451c0);
            e.this.M1();
            if (e.this.X != null) {
                e.this.X.f(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M1() {
        int i3 = this.Z;
        if (i3 == 0) {
            this.f433450b0++;
            t1(true);
        } else if (i3 == this.f433449a0 - 1) {
            s1(true);
        }
    }

    private void N1() {
        QFSImageBanner qFSImageBanner = this.V;
        if (qFSImageBanner == null) {
            return;
        }
        qFSImageBanner.setEnableOperate(true);
        this.V.setOnSwitchListener(new b());
    }

    private void O1() {
        ImageView imageView = this.T;
        if (imageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = DisplayUtil.dip2px(m0(), 10.0f);
            this.T.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P1() {
        this.V.setCurrentItem(0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q1(int i3, int i16) {
        TextView textView = this.Y;
        if (textView != null) {
            textView.setText((i3 + 1) + "/" + i16);
        }
    }

    @Override // s80.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.f433452d0 = ac0.c.a();
        this.V = (QFSImageBanner) view.findViewById(R.id.f516728q);
        p80.e eVar = new p80.e();
        this.W = eVar;
        eVar.setEnableLoop(true);
        this.V.setAdapter(this.W);
        this.V.setEnableOperate(false);
        this.V.q0(new a());
        this.V.setOnItemClickListener(this);
        this.V.X().setOffscreenPageLimit(1);
        this.Y = (TextView) view.findViewById(R.id.f56182jx);
        this.X = (QFSGalleryProgressViewNoAnim) view.findViewById(R.id.f40941fq);
        if (this.f433452d0) {
            View findViewById = view.findViewById(R.id.f489121_);
            this.U = findViewById;
            findViewById.setVisibility(0);
            this.X.setVisibility(0);
            this.X.setPosChangeListener(new QFSGalleryProgressViewNoAnim.a() { // from class: s80.d
                @Override // com.tencent.biz.qqcircle.immersive.gallery.view.QFSGalleryProgressViewNoAnim.a
                public final void a(int i3, int i16) {
                    e.this.Q1(i3, i16);
                }
            });
            O1();
            N1();
            return;
        }
        View findViewById2 = view.findViewById(R.id.f4890219);
        this.U = findViewById2;
        findViewById2.setVisibility(0);
    }

    @Override // s80.b, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        super.a();
        this.V.y0();
    }

    @Override // s80.b
    public void i1() {
        if (this.C == null) {
            return;
        }
        this.U.setVisibility(8);
        this.V.setVisibility(8);
        this.W.v0(null);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.c
    public void onItemClick(int i3) {
        l1();
    }

    @Override // s80.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: p1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (this.f85017h == feedCloudMeta$StFeed) {
            return;
        }
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        this.V.setVisibility(0);
        this.J.setVisibility(4);
        if (!this.R.f()) {
            this.U.setVisibility(0);
        }
        this.f433449a0 = feedCloudMeta$StFeed.images.size();
        this.f433450b0 = 0;
        this.W.v0(feedCloudMeta$StFeed.images.get());
        this.V.post(new Runnable() { // from class: s80.c
            @Override // java.lang.Runnable
            public final void run() {
                e.this.P1();
            }
        });
        QFSGalleryProgressViewNoAnim qFSGalleryProgressViewNoAnim = this.X;
        if (qFSGalleryProgressViewNoAnim != null) {
            qFSGalleryProgressViewNoAnim.setTotalCount(this.f433449a0);
            this.X.f(0);
            if (this.f433449a0 <= 1) {
                this.X.setVisibility(8);
            } else {
                this.X.setVisibility(0);
            }
        }
    }

    @Override // s80.b, e80.g, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void pause() {
        super.pause();
        this.V.y0();
    }

    @Override // s80.b, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        if (isPlaying()) {
            return;
        }
        super.play();
        this.R.onPlay();
        this.V.v0();
        QFSSearchPrerenderManager.E(m0()).r("feed", this.f85018i);
    }

    @Override // s80.b
    protected void q1(int i3, int i16) {
        ViewGroup.LayoutParams layoutParams = this.V.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        this.V.setLayoutParams(layoutParams);
        this.W.w0(new Size(i3, i16));
    }

    @Override // s80.b
    protected void s1(boolean z16) {
        this.S.d(this.C, this.f433449a0, this.Z, z16);
    }

    @Override // s80.b, e80.g
    public void stop() {
        if (!isPlaying()) {
            return;
        }
        super.stop();
        this.V.y0();
    }

    @Override // s80.b
    protected void t1(boolean z16) {
        this.S.e(this.C, this.Z, z16, this.f433450b0);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchFeedResultImageBannerPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements QFSImageBanner.h {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.h
        public void c() {
            if (e.this.V != null) {
                e.this.V.y0();
            }
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.h
        public void a(int i3) {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.h
        public void b(int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s80.b
    public void n1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16) {
    }
}
