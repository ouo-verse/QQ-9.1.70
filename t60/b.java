package t60;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.adapter.ap;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.part.QFSBaseBlockPart;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import p70.j;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends QFSBaseBlockPart {

    /* renamed from: d, reason: collision with root package name */
    private final ap f435467d;

    /* renamed from: e, reason: collision with root package name */
    private j f435468e;

    /* renamed from: f, reason: collision with root package name */
    private QFSSearchInfo f435469f;

    public b() {
        super(R.id.f53622d0, null, 1, 1);
        ap apVar = new ap(null);
        this.f435467d = apVar;
        this.mPeerBlocks.add(apVar);
    }

    private void A9(UIStateData<List<g30.b>> uIStateData) {
        this.f435467d.setDatas(uIStateData.getData());
        this.f435467d.getLoadInfo().setFinish(uIStateData.getIsFinish());
        this.f435467d.notifyLoadingComplete(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B9(UIStateData<List<g30.b>> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        int state = uIStateData.getState();
        if (state != 0) {
            if (state != 2 && state != 3) {
                if (state == 4) {
                    QLog.w("QFSSearchSuggestPart", 1, "#handleSuggestionRsp: errMsg=" + uIStateData.getMsg());
                } else {
                    return;
                }
            } else {
                A9(uIStateData);
                return;
            }
        }
        z9();
    }

    private void C9(QFSSearchInfo qFSSearchInfo) {
        String f16;
        if (this.f435469f == qFSSearchInfo) {
            return;
        }
        this.f435469f = qFSSearchInfo;
        if (qFSSearchInfo == null) {
            f16 = null;
        } else {
            f16 = qFSSearchInfo.f();
        }
        this.f435468e.P1(f16);
    }

    private void z9() {
        this.f435467d.setDatas(null);
        this.f435467d.getLoadInfo().setFinish(true);
        this.f435467d.notifyLoadingComplete(true);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchSuggestPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("updateData".equals(str) && (obj instanceof QFSSearchInfo)) {
            C9((QFSSearchInfo) obj);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSBaseBlockPart, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.mBlockContainer.setParentFragment(getHostFragment());
        this.mBlockContainer.setEnableRefresh(false);
        this.mBlockContainer.setEnableLoadMore(false);
        j jVar = (j) getViewModel(j.class);
        this.f435468e = jVar;
        jVar.M1().observe(getHostFragment(), new Observer() { // from class: t60.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                b.this.B9((UIStateData) obj);
            }
        });
        Bundle arguments = getHostFragment().getArguments();
        if (arguments != null) {
            C9((QFSSearchInfo) arguments.getParcelable("data"));
        }
    }
}
