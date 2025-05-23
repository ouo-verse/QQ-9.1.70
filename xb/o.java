package xb;

import android.view.View;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lxb/o;", "Lv9/b;", "", "e", "", "getLogTag", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class o extends v9.b {
    private final void e() {
        RFWIocAbilityProvider.g().getIoc(hb.i.class).originView(getRootView()).done(new OnPromiseResolved() { // from class: xb.n
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                o.z(o.this, (hb.i) obj);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void z(o this$0, hb.i iVar) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (((CommonAlbumListBean) this$0.mData).getAlbumInfo().getMemoryInfo().b().size() > 1) {
            str = ((CommonAlbumListBean) this$0.mData).getAlbumInfo().getMemoryInfo().getAggregationPageUrl();
        } else if (((CommonAlbumListBean) this$0.mData).getAlbumInfo().getMemoryInfo().b().size() > 0) {
            str = ((CommonAlbumListBean) this$0.mData).getAlbumInfo().getMemoryInfo().b().get(0).getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String();
        } else {
            str = "";
        }
        QLog.i("QZAlbumxAlbumListTimeMachineNameSection", 1, "clickAlbumItemView  url = " + str);
        ho.i.q(this$0.getRootView().getContext(), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumListTimeMachineNameSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n3s) {
            e();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
