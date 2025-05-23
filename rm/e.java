package rm;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import com.qzone.reborn.publicaccount.g;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001%B#\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010 0\u0006\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001e\u0010\t\u001a\u00020\u00032\u0014\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005H\u0002J\u001c\u0010\u000b\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\u0002J\u001a\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006&"}, d2 = {"Lrm/e;", "Lcom/qzone/reborn/base/c;", "Lqm/a;", "", "E9", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lmm/a;", "rspUIStateData", "B9", "data", "C9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", "mRootView", "onInitView", "messageData", "T5", "Lcom/qzone/reborn/publicaccount/d;", "d", "Lcom/qzone/reborn/publicaccount/d;", "mMsgListAdapter", "Lcom/qzone/reborn/publicaccount/g;", "e", "Lcom/qzone/reborn/publicaccount/g;", "mMsgListViewModel", "", "peerBlockFindViewId", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "peerBlocks", "<init>", "(ILjava/util/List;)V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e extends com.qzone.reborn.base.c implements qm.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.publicaccount.d mMsgListAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private g mMsgListViewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i3, List<? extends MultiViewBlock<?>> peerBlocks) {
        super(i3, peerBlocks);
        Intrinsics.checkNotNullParameter(peerBlocks, "peerBlocks");
        for (MultiViewBlock<?> multiViewBlock : peerBlocks) {
            if (multiViewBlock instanceof com.qzone.reborn.publicaccount.d) {
                this.mMsgListAdapter = (com.qzone.reborn.publicaccount.d) multiViewBlock;
                return;
            }
        }
    }

    private final void C9(UIStateData<List<mm.a>> data) {
        List<mm.a> data2 = data.getData();
        if (data2 != null && !data2.isEmpty()) {
            com.qzone.reborn.publicaccount.d dVar = this.mMsgListAdapter;
            if (dVar != null) {
                dVar.setDatas(data2);
                return;
            }
            return;
        }
        RFWLog.e("QZonePublicAcntMsgListBlockPart", RFWLog.USR, "msgDataList is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(e this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mMsgListAdapter != null) {
            this$0.B9(uIStateData);
        }
    }

    private final void E9() {
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer == null || blockContainer.getRecyclerView() == null) {
            return;
        }
        this.mBlockContainer.getRecyclerView().setItemAnimator(new DefaultItemAnimator());
    }

    @Override // qm.a
    public void T5(mm.a messageData) {
        g gVar = this.mMsgListViewModel;
        if (gVar == null) {
            RFWLog.e("QZonePublicAcntMsgListBlockPart", RFWLog.USR, "view model is null");
        } else {
            Intrinsics.checkNotNull(gVar);
            gVar.S1(messageData);
        }
    }

    @Override // com.qzone.reborn.base.c, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View mRootView) {
        MutableLiveData<UIStateData<List<mm.a>>> R1;
        super.onInitView(mRootView);
        this.mMsgListViewModel = (g) getViewModel(g.class);
        this.mBlockContainer.setLayoutManagerType(1, 1);
        this.mBlockContainer.setParentFragment(getHostFragment());
        this.mBlockContainer.setEnableLoadMore(true);
        this.mBlockContainer.setEnableRefresh(true);
        E9();
        g gVar = this.mMsgListViewModel;
        if (gVar == null || (R1 = gVar.R1()) == null) {
            return;
        }
        R1.observe(getHostFragment(), new Observer() { // from class: rm.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                e.D9(e.this, (UIStateData) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        registerIoc(this, qm.a.class);
    }

    private final void B9(UIStateData<List<mm.a>> rspUIStateData) {
        if (rspUIStateData == null) {
            return;
        }
        int state = rspUIStateData.getState();
        if (state == 0) {
            QLog.e("QZonePublicAcntMsgListBlockPart", 1, "handleDetailRsp() return empty data");
            com.qzone.reborn.publicaccount.d dVar = this.mMsgListAdapter;
            if (dVar != null) {
                dVar.notifyLoadingComplete(false);
                return;
            }
            return;
        }
        if (state == 6 || state == 2 || state == 3) {
            com.qzone.reborn.publicaccount.d dVar2 = this.mMsgListAdapter;
            if (dVar2 != null) {
                dVar2.notifyLoadingComplete(true, rspUIStateData.getIsFinish());
            }
            C9(rspUIStateData);
            return;
        }
        if (state != 4) {
            return;
        }
        QLog.e("QZonePublicAcntMsgListBlockPart", 1, "handleDetailRsp() return error  | retCode = " + rspUIStateData.getRetCode() + " | msg = " + rspUIStateData.getMsg());
        com.qzone.reborn.publicaccount.d dVar3 = this.mMsgListAdapter;
        if (dVar3 != null) {
            dVar3.notifyLoadingComplete(false);
        }
        if (TextUtils.isEmpty(rspUIStateData.getMsg())) {
            return;
        }
        ToastUtil.s(rspUIStateData.getMsg(), 1);
    }
}
