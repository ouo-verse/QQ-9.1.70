package s20;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.comment.abovebar.QFSCommentRecPicBar;
import com.tencent.biz.qqcircle.comment.recpic.aa;
import com.tencent.biz.qqcircle.comment.recpic.ai;
import com.tencent.biz.qqcircle.comment.recpic.ak;
import com.tencent.biz.qqcircle.comment.recpic.sorter.StrategyImage;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSCommentPicSelectEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h extends RecyclerView.ViewHolder {
    private final ImageView E;
    private final TextView F;
    private final TextView G;
    private final WeakReference<QFSCommentRecPicBar> H;

    public h(@NonNull View view, QFSCommentRecPicBar qFSCommentRecPicBar) {
        super(view);
        this.H = new WeakReference<>(qFSCommentRecPicBar);
        this.E = (ImageView) view.findViewById(R.id.dce);
        this.F = (TextView) view.findViewById(R.id.jjd);
        this.G = (TextView) view.findViewById(R.id.jje);
    }

    private void p(StrategyImage strategyImage) {
        if (!aa.f83750a.G()) {
            return;
        }
        if (strategyImage.getScore() != 0.0f) {
            this.F.setText(String.valueOf(strategyImage.getScore()));
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(8);
        }
        if (strategyImage.getStrategy() != 0) {
            this.G.setText("\u7b56\u7565" + strategyImage.getStrategy());
            this.G.setVisibility(0);
            return;
        }
        this.G.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(StrategyImage strategyImage, int i3, int i16, int i17, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ak akVar = ak.f83788a;
        akVar.h(strategyImage);
        if (this.H.get() != null) {
            this.H.get().W(false, false);
            akVar.e(this.itemView, i3, strategyImage, this.H.get().G(), false);
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSCommentPicSelectEvent(strategyImage.getPath(), i16, i17));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean r(View view) {
        this.itemView.getParent().requestDisallowInterceptTouchEvent(true);
        ai.c(view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean s(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1) {
            ai.b();
            return false;
        }
        return false;
    }

    public void o(final StrategyImage strategyImage, final int i3) {
        final int i16;
        p(strategyImage);
        strategyImage.b().put("index", Integer.valueOf(i3));
        Option obtain = Option.obtain();
        Object obj = strategyImage.b().get("w");
        Object obj2 = strategyImage.b().get(tl.h.F);
        int i17 = 0;
        if (obj != null) {
            i16 = ((Integer) obj).intValue();
        } else {
            i16 = 0;
        }
        if (obj2 != null) {
            i17 = ((Integer) obj2).intValue();
        }
        final int i18 = i17;
        this.itemView.setTag(-4, strategyImage.getPath());
        this.itemView.setTag(-5, strategyImage);
        obtain.setUrl(strategyImage.getPath()).setTargetView(this.E);
        QCircleFeedPicLoader.g().loadImage(obtain);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: s20.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.this.q(strategyImage, i3, i16, i18, view);
            }
        });
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: s20.f
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean r16;
                r16 = h.this.r(view);
                return r16;
            }
        });
        this.itemView.setOnTouchListener(new View.OnTouchListener() { // from class: s20.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean s16;
                s16 = h.s(view, motionEvent);
                return s16;
            }
        });
    }
}
