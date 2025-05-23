package s20;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart;
import com.tencent.biz.qqcircle.comment.abovebar.QFSCommentRecPicBar;
import com.tencent.biz.qqcircle.comment.recpic.QFSCommentRecPicClusterHelper;
import com.tencent.biz.qqcircle.comment.recpic.aa;
import com.tencent.biz.qqcircle.comment.recpic.sorter.StrategyImage;
import com.tencent.biz.qqcircle.widgets.RoundFrameLayout;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final QFSCommentRecPicBar C;

    /* renamed from: m, reason: collision with root package name */
    private final ArrayList<StrategyImage> f433092m;

    public b(QFSCommentRecPicBar qFSCommentRecPicBar) {
        ArrayList<StrategyImage> arrayList = new ArrayList<>();
        this.f433092m = arrayList;
        this.C = qFSCommentRecPicBar;
        List<StrategyImage> G = QFSCommentRecPicClusterHelper.f83716a.G(qFSCommentRecPicBar.i());
        if (G != null) {
            arrayList.addAll(G);
            i0();
            j0(G);
        }
    }

    private void i0() {
        if ((this.C.h() instanceof Activity) && !aa.f83750a.E((Activity) this.C.h())) {
            HashMap hashMap = new HashMap();
            hashMap.put("feedId", this.C.i());
            hashMap.put("reportBean", this.C.G());
            this.f433092m.add(new StrategyImage("", 0, 0.0f, "", hashMap));
        }
    }

    private void j0(List<StrategyImage> list) {
        if (!RFSafeListUtils.isEmpty(list) && this.C != null) {
            if (list.size() > 10) {
                list = list.subList(0, 10);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("feedId: ");
            sb5.append(this.C.i());
            for (StrategyImage strategyImage : list) {
                sb5.append(", \u7b56\u7565\uff1a");
                sb5.append(strategyImage.getStrategy());
                sb5.append(", \u5f97\u5206\uff1a");
                sb5.append(strategyImage.getScore());
                if (strategyImage.b().containsKey("hashId")) {
                    sb5.append(", hashId\uff1a");
                    sb5.append(strategyImage.b().get("hashId"));
                }
                sb5.append(APLogFileUtil.SEPARATOR_LOG);
            }
            QLog.d(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 1, "candidate pic info: " + ((Object) sb5));
        }
    }

    public void addData(List<StrategyImage> list) {
        this.f433092m.clear();
        this.f433092m.addAll(list);
        i0();
        j0(list);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: s20.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.notifyDataSetChanged();
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f433092m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (this.f433092m.get(i3).getPath().isEmpty()) {
            return 2;
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof h) {
            ((h) viewHolder).o(this.f433092m.get(i3), i3);
        } else if (viewHolder instanceof d) {
            ((d) viewHolder).m(this.f433092m.get(i3));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        Context context = viewGroup.getContext();
        int dip2px = DisplayUtil.dip2px(context, 6.0f);
        int dip2px2 = DisplayUtil.dip2px(context, 80.0f);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(dip2px2, dip2px2);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = DisplayUtil.dip2px(context, 5.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = DisplayUtil.dip2px(context, 5.0f);
        if (i3 == 2) {
            RoundFrameLayout roundFrameLayout = (RoundFrameLayout) LayoutInflater.from(context).inflate(R.layout.g_5, (ViewGroup) null, false);
            roundFrameLayout.setRadius(dip2px);
            roundFrameLayout.setLayoutParams(layoutParams);
            return new d(roundFrameLayout);
        }
        RoundFrameLayout roundFrameLayout2 = (RoundFrameLayout) LayoutInflater.from(context).inflate(R.layout.g_3, (ViewGroup) null, false);
        roundFrameLayout2.setRadius(dip2px);
        roundFrameLayout2.setLayoutParams(layoutParams);
        return new h(roundFrameLayout2, this.C);
    }
}
