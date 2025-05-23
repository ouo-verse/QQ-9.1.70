package xb;

import android.app.Activity;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAnswerCheckPageInitBean;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J*\u0010\u000f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0013H\u0016\u00a8\u0006\u001e"}, d2 = {"Lxb/k;", "Lv9/e;", "Lhb/b;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "data", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "", "getLogTag", "", "position", "", "", "payload", UserInfo.SEX_FEMALE, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "", NodeProps.VISIBLE, "onVisibleChanged", "e", BdhLogUtil.LogTag.Tag_Conn, "attached", "onAttachedChanged", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class k extends v9.e implements hb.b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(k this$0, hb.i iVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = "mqqapi://qcircle/openmainpage?uin=" + iVar.A7().b2().getUin();
        QLog.i("QZAlbumxAlbumListNormalSection", 1, "active video url is " + str);
        ho.i.q(this$0.p(), str);
        this$0.R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void O(k this$0, hb.i iVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QZAlbumxAnswerCheckPageInitBean qZAlbumxAnswerCheckPageInitBean = new QZAlbumxAnswerCheckPageInitBean(iVar.A7().b2().getUin());
        qZAlbumxAnswerCheckPageInitBean.setAlbumId(((CommonAlbumListBean) this$0.mData).getAlbumInfo().getAlbumId());
        qZAlbumxAnswerCheckPageInitBean.setOwnerUin(((CommonAlbumListBean) this$0.mData).getAlbumInfo().getCreator().getUin());
        qZAlbumxAnswerCheckPageInitBean.setOwnerUid(((CommonAlbumListBean) this$0.mData).getAlbumInfo().getCreator().getUid());
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = new QZAlbumxAlbumDetailInitBean(iVar.A7().b2().getUin());
        qZAlbumxAlbumDetailInitBean.setAlbumId(((CommonAlbumListBean) this$0.mData).getAlbumInfo().getAlbumId());
        qZAlbumxAlbumDetailInitBean.setAlbumName(((CommonAlbumListBean) this$0.mData).getAlbumInfo().getName());
        qZAlbumxAlbumDetailInitBean.setSortType(Integer.valueOf(((CommonAlbumListBean) this$0.mData).getAlbumInfo().getSortType()));
        qZAlbumxAnswerCheckPageInitBean.setJumpExtData(qZAlbumxAlbumDetailInitBean);
        qZAlbumxAnswerCheckPageInitBean.setFromType(1);
        vb.b x16 = ho.i.x();
        Activity activity = this$0.p();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        x16.d(activity, 0, qZAlbumxAnswerCheckPageInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void P(k this$0, hb.i iVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = new QZAlbumxAlbumDetailInitBean(iVar.A7().b2().getUin());
        qZAlbumxAlbumDetailInitBean.setAlbumId(((CommonAlbumListBean) this$0.mData).getAlbumInfo().getAlbumId());
        qZAlbumxAlbumDetailInitBean.setAlbumName(((CommonAlbumListBean) this$0.mData).getAlbumInfo().getName());
        qZAlbumxAlbumDetailInitBean.setSortType(Integer.valueOf(((CommonAlbumListBean) this$0.mData).getAlbumInfo().getSortType()));
        vb.b x16 = ho.i.x();
        Activity activity = this$0.p();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        x16.g(activity, qZAlbumxAlbumDetailInitBean);
    }

    private final void R() {
        boolean p16 = dh.a.f393805d.p();
        QLog.i("QZ_QFS_QZAlbumxAlbumListNormalSection", 1, "handleClickClearQCircleRedDotInfo  | showQcircleEntranceRedDot=" + p16);
        if (p16) {
            RFWIocAbilityProvider.g().getIoc(hb.h.class).originView(getRootView()).done(new OnPromiseResolved() { // from class: xb.i
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj) {
                    k.S((hb.h) obj);
                }
            }).run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(final hb.h hVar) {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: xb.j
            @Override // java.lang.Runnable
            public final void run() {
                k.T(hb.h.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(hb.h hVar) {
        dh.a.f393805d.l(false);
        hVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // v9.e
    public String C() {
        if (((CommonAlbumListBean) this.mData).getAlbumInfo().getQzAlbumType() == 14) {
            return com.qzone.util.l.a(R.string.f133897c);
        }
        return super.C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: F */
    public void onBindData(CommonAlbumListBean data, int position, List<Object> payload) {
        super.onBindData(data, position, payload);
        Q(data);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // hb.b
    public void e() {
        if (((CommonAlbumListBean) this.mData).getAlbumInfo().getQzAlbumType() == 14) {
            QLog.i("QZ_QFS_QZAlbumxAlbumListNormalSection", 1, "clickAlbumItemView type is qcircle");
            RFWIocAbilityProvider.g().getIoc(hb.i.class).originView(getRootView()).done(new OnPromiseResolved() { // from class: xb.f
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj) {
                    k.N(k.this, (hb.i) obj);
                }
            }).run();
            return;
        }
        if (((CommonAlbumListBean) this.mData).getAlbumInfo().getActiveAlbumInfo().getIsActiveAlbum()) {
            String str = ((CommonAlbumListBean) this.mData).getAlbumInfo().getActiveAlbumInfo().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String();
            QLog.i("QZAlbumxAlbumListNormalSection", 1, "active jump url is " + str);
            ho.i.q(p(), str);
            return;
        }
        com.qzone.reborn.feedx.util.m.b("extra_key_parcelable_album_info_for_detail", ((CommonAlbumListBean) this.mData).getAlbumInfo());
        if (((CommonAlbumListBean) this.mData).getAlbumInfo().getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType() == 5 && !Intrinsics.areEqual(((CommonAlbumListBean) this.mData).getAlbumInfo().getCreator().getUin(), LoginData.getInstance().getUinString()) && !com.qzone.reborn.albumx.qzonex.utils.e.f53405a.e(((CommonAlbumListBean) this.mData).getAlbumInfo().getAlbumId())) {
            RFWIocAbilityProvider.g().getIoc(hb.i.class).originView(getRootView()).done(new OnPromiseResolved() { // from class: xb.g
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj) {
                    k.O(k.this, (hb.i) obj);
                }
            }).run();
        } else {
            RFWIocAbilityProvider.g().getIoc(hb.i.class).originView(getRootView()).done(new OnPromiseResolved() { // from class: xb.h
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj) {
                    k.P(k.this, (hb.i) obj);
                }
            }).run();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumListNormalSection";
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        super.onAttachedChanged(attached);
        if (attached) {
            RFWIocAbilityProvider.g().registerIoc(getRootView(), this, hb.b.class);
        } else {
            RFWIocAbilityProvider.g().unregisterSingleIoc(getRootView(), hb.b.class);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n3j) {
            e();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        super.onVisibleChanged(visible);
        if (visible && ((CommonAlbumListBean) this.mData).getAlbumInfo().getQzAlbumType() == 14) {
            QLog.i("QZ_QFS_QZAlbumxAlbumListNormalSection", 1, "onVisibleChanged visible, type is qcircle");
            dh.a.f393805d.q(B());
        }
    }

    private final void Q(CommonAlbumListBean data) {
        if (data == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("albumid", data.getAlbumInfo().getAlbumId());
        linkedHashMap.put("album_name", data.getAlbumInfo().getName());
        fo.c.o(B(), "em_qz_album", new fo.b().l(linkedHashMap).i(data.getAlbumInfo().getAlbumId()));
    }
}
