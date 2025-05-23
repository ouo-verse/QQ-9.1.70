package zj;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.base.k;
import com.qzone.reborn.intimate.bean.QZoneAlbumInfoBean;
import com.qzone.reborn.intimate.event.QZoneIntimateEditAlbumEvent;
import com.qzone.reborn.intimate.event.QZoneIntimateUploadAlbumEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nk.r;
import qzone.QZIntimateSpaceAlbum$AlbumSpaceInfo;
import qzone.QZIntimateSpaceAlbum$GetAlbumListRsp;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\tH\u0002J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J#\u0010\u0016\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\tH\u0002J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J$\u0010#\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!0 j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!`\"H\u0016J\u0012\u0010$\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%H\u0016R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lzj/f;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initViewModel", "Lcom/qzone/reborn/intimate/event/QZoneIntimateUploadAlbumEvent;", "event", "I9", "Lcom/qzone/reborn/intimate/event/QZoneIntimateEditAlbumEvent;", "J9", "", "spaceId", "", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "H9", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "L9", "", "localTopFlag", "eventTopFlag", "K9", "(Ljava/lang/Long;Ljava/lang/Long;)Z", "D9", "G9", "", "position", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onReceiveEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lnk/r;", "d", "Lnk/r;", "mAlbumViewModel", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f extends k implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private r mAlbumViewModel;

    private final void D9() {
        RFWLog.i("QZoneAlbumIntimateTabOperatePart", RFWLog.USR, "create album success and refresh");
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: zj.e
            @Override // java.lang.Runnable
            public final void run() {
                f.E9(f.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        r rVar = null;
        this$0.broadcastMessage("QZONE_INTIMATE_SCROLL_TOP", null);
        r rVar2 = this$0.mAlbumViewModel;
        if (rVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            rVar = rVar2;
        }
        rVar.U1();
    }

    private final void F9(QZoneIntimateEditAlbumEvent event, int position) {
        RFWLog.i("QZoneAlbumIntimateTabOperatePart", RFWLog.USR, "delete album success and refresh adapter");
        r rVar = this.mAlbumViewModel;
        r rVar2 = null;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            rVar = null;
        }
        for (QZoneAlbumInfoBean qZoneAlbumInfoBean : rVar.P1()) {
            if (Intrinsics.areEqual(event.getSpaceId(), qZoneAlbumInfoBean.getAlbumInfo().space_id.get())) {
                qZoneAlbumInfoBean.getAlbumInfo().album_list.album_list.get().remove(position);
            }
        }
        r rVar3 = this.mAlbumViewModel;
        if (rVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            rVar2 = rVar3;
        }
        rVar2.T1();
    }

    private final void G9(QZoneBaseAlbumMeta$AlbumInfo item, QZoneIntimateEditAlbumEvent event) {
        RFWLog.i("QZoneAlbumIntimateTabOperatePart", RFWLog.USR, "edit album success and refresh adapter");
        item.set(event.getEditAlbum());
        r rVar = this.mAlbumViewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            rVar = null;
        }
        rVar.T1();
    }

    private final List<QZoneBaseAlbumMeta$AlbumInfo> H9(String spaceId) {
        Object obj;
        QZIntimateSpaceAlbum$AlbumSpaceInfo albumInfo;
        QZIntimateSpaceAlbum$GetAlbumListRsp qZIntimateSpaceAlbum$GetAlbumListRsp;
        PBRepeatMessageField<QZoneBaseAlbumMeta$AlbumInfo> pBRepeatMessageField;
        r rVar = this.mAlbumViewModel;
        List<QZoneBaseAlbumMeta$AlbumInfo> list = null;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            rVar = null;
        }
        Iterator<T> it = rVar.P1().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(spaceId, ((QZoneAlbumInfoBean) obj).getAlbumInfo().space_id.get())) {
                break;
            }
        }
        QZoneAlbumInfoBean qZoneAlbumInfoBean = (QZoneAlbumInfoBean) obj;
        if (qZoneAlbumInfoBean != null && (albumInfo = qZoneAlbumInfoBean.getAlbumInfo()) != null && (qZIntimateSpaceAlbum$GetAlbumListRsp = albumInfo.album_list) != null && (pBRepeatMessageField = qZIntimateSpaceAlbum$GetAlbumListRsp.album_list) != null) {
            list = pBRepeatMessageField.get();
        }
        return list == null ? new ArrayList() : list;
    }

    private final void I9(QZoneIntimateUploadAlbumEvent event) {
        Object obj;
        r rVar = this.mAlbumViewModel;
        r rVar2 = null;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            rVar = null;
        }
        if (bl.b(rVar.P1())) {
            RFWLog.i("QZoneAlbumIntimateTabOperatePart", RFWLog.USR, "album list is none");
            return;
        }
        Iterator<T> it = H9(event.getSpaceId()).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(event.getAlbumId(), ((QZoneBaseAlbumMeta$AlbumInfo) obj).album_id.get())) {
                    break;
                }
            }
        }
        if (((QZoneBaseAlbumMeta$AlbumInfo) obj) != null) {
            r rVar3 = this.mAlbumViewModel;
            if (rVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            } else {
                rVar2 = rVar3;
            }
            rVar2.U1();
        }
    }

    private final void J9(QZoneIntimateEditAlbumEvent event) {
        PBStringField pBStringField;
        PBStringField pBStringField2;
        if (event.getAddAlbum() != null) {
            D9();
            return;
        }
        r rVar = this.mAlbumViewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            rVar = null;
        }
        if (bl.b(rVar.P1())) {
            RFWLog.i("QZoneAlbumIntimateTabOperatePart", RFWLog.USR, "album list is none");
            return;
        }
        List<QZoneBaseAlbumMeta$AlbumInfo> H9 = H9(event.getSpaceId());
        int size = H9.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i3 = size - 1;
            QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo = H9.get(size);
            if (L9(event, qZoneBaseAlbumMeta$AlbumInfo)) {
                return;
            }
            QZoneBaseAlbumMeta$AlbumInfo editAlbum = event.getEditAlbum();
            if (Intrinsics.areEqual((editAlbum == null || (pBStringField2 = editAlbum.album_id) == null) ? null : pBStringField2.get(), qZoneBaseAlbumMeta$AlbumInfo.album_id.get())) {
                G9(qZoneBaseAlbumMeta$AlbumInfo, event);
                return;
            }
            QZoneBaseAlbumMeta$AlbumInfo deleteAlbum = event.getDeleteAlbum();
            if (Intrinsics.areEqual((deleteAlbum == null || (pBStringField = deleteAlbum.album_id) == null) ? null : pBStringField.get(), qZoneBaseAlbumMeta$AlbumInfo.album_id.get())) {
                F9(event, size);
                return;
            } else if (i3 < 0) {
                return;
            } else {
                size = i3;
            }
        }
    }

    private final boolean K9(Long localTopFlag, Long eventTopFlag) {
        return !Intrinsics.areEqual(localTopFlag, eventTopFlag);
    }

    private final boolean L9(QZoneIntimateEditAlbumEvent event, QZoneBaseAlbumMeta$AlbumInfo item) {
        PBUInt64Field pBUInt64Field;
        PBStringField pBStringField;
        QZoneBaseAlbumMeta$AlbumInfo editAlbum = event.getEditAlbum();
        r rVar = null;
        if (!Intrinsics.areEqual((editAlbum == null || (pBStringField = editAlbum.album_id) == null) ? null : pBStringField.get(), item.album_id.get())) {
            return false;
        }
        QZoneBaseAlbumMeta$AlbumInfo editAlbum2 = event.getEditAlbum();
        if (!K9((editAlbum2 == null || (pBUInt64Field = editAlbum2.top_flag) == null) ? null : Long.valueOf(pBUInt64Field.get()), Long.valueOf(item.top_flag.get()))) {
            return false;
        }
        RFWLog.i("QZoneAlbumIntimateTabOperatePart", RFWLog.USR, "hasDiffTopFlag and refresh");
        broadcastMessage("QZONE_INTIMATE_SCROLL_TOP", null);
        r rVar2 = this.mAlbumViewModel;
        if (rVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            rVar = rVar2;
        }
        rVar.U1();
        return true;
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(r.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneAlbumI\u2026TabViewModel::class.java)");
        this.mAlbumViewModel = (r) viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        SimpleEventBus.getInstance().registerReceiver(this);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZoneIntimateEditAlbumEvent) {
            J9((QZoneIntimateEditAlbumEvent) event);
        } else if (event instanceof QZoneIntimateUploadAlbumEvent) {
            I9((QZoneIntimateUploadAlbumEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZoneIntimateEditAlbumEvent.class, QZoneIntimateUploadAlbumEvent.class);
        return arrayListOf;
    }
}
