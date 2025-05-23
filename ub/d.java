package ub;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceDeleteAlbumMediaCallback;
import com.tencent.qqnt.kernel.nativeinterface.PADeleteAlbumMediaReq;
import com.tencent.qqnt.kernel.nativeinterface.PADeleteAlbumMediaRsp;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJN\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u001a\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\nj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0006J\u001e\u0010\u0015\u001a\u00020\u00022\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00130\nj\b\u0012\u0004\u0012\u00020\u0013`\u000bJ\u001e\u0010\u0016\u001a\u00020\u00022\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00130\nj\b\u0012\u0004\u0012\u00020\u0013`\u000bJ\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0017\u00a8\u0006\u001b"}, d2 = {"Lub/d;", "", "", "isSuccess", "", "retCode", "", "errMsg", "Lo9/f;", "requestBean", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "batchId", "Lub/a;", "dataRepo", "", "c", "uid", "f", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "mediaList", "e", "d", "Lwa/a;", "g", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f438671a = new d();

    d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(long j3, final wa.a requestBean, final ArrayList batchList, final PADeleteAlbumMediaRsp pADeleteAlbumMediaRsp) {
        Intrinsics.checkNotNullParameter(requestBean, "$requestBean");
        Intrinsics.checkNotNullParameter(batchList, "$batchList");
        mc.c.f416541a.e("deleteAlbumMedia", System.currentTimeMillis() - j3, pADeleteAlbumMediaRsp.result);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: ub.c
            @Override // java.lang.Runnable
            public final void run() {
                d.i(PADeleteAlbumMediaRsp.this, requestBean, batchList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(PADeleteAlbumMediaRsp pADeleteAlbumMediaRsp, wa.a requestBean, ArrayList batchList) {
        Intrinsics.checkNotNullParameter(requestBean, "$requestBean");
        Intrinsics.checkNotNullParameter(batchList, "$batchList");
        d dVar = f438671a;
        int i3 = pADeleteAlbumMediaRsp.result;
        boolean z16 = i3 == 0;
        String str = pADeleteAlbumMediaRsp.errMs;
        Intrinsics.checkNotNullExpressionValue(str, "response.errMs");
        dVar.c(z16, i3, str, requestBean, batchList, requestBean.getDataRepo());
    }

    public final boolean d(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return false;
        }
        Iterator<CommonStMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            String str = it.next().getCom.tencent.weiyun.transmission.db.JobDbManager.TBL_UPLOAD java.lang.String();
            if (str == null) {
                str = "";
            }
            if (f(str)) {
                return false;
            }
        }
        return true;
    }

    public final boolean e(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return false;
        }
        Iterator<CommonStMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            String str = it.next().getCom.tencent.weiyun.transmission.db.JobDbManager.TBL_UPLOAD java.lang.String();
            if (str == null) {
                str = "";
            }
            if (!f(str)) {
                return false;
            }
        }
        return true;
    }

    public final boolean f(String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        return TextUtils.equals(uid, LoginData.getInstance().getUid()) || TextUtils.equals(uid, String.valueOf(LoginData.getInstance().getUin()));
    }

    public final void g(final wa.a requestBean) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        requestBean.g(requestBean.c());
        ArrayList<String> arrayList = new ArrayList<>();
        final ArrayList arrayList2 = new ArrayList();
        for (CommonStMedia commonStMedia : requestBean.c()) {
            fj.p pVar = fj.p.f399467a;
            arrayList.add(pVar.i(commonStMedia));
            arrayList2.add(pVar.h(commonStMedia));
        }
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        PADeleteAlbumMediaReq pADeleteAlbumMediaReq = new PADeleteAlbumMediaReq();
        pADeleteAlbumMediaReq.picidList = arrayList;
        pADeleteAlbumMediaReq.albumId = requestBean.getAlbumId();
        pADeleteAlbumMediaReq.vids = arrayList;
        final long currentTimeMillis = System.currentTimeMillis();
        if (b16 != null) {
            b16.deleteAlbumMedia(pADeleteAlbumMediaReq, new IPersonalAlbumServiceDeleteAlbumMediaCallback() { // from class: ub.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceDeleteAlbumMediaCallback
                public final void onDeleteAlbumMedia(PADeleteAlbumMediaRsp pADeleteAlbumMediaRsp) {
                    d.h(currentTimeMillis, requestBean, arrayList2, pADeleteAlbumMediaRsp);
                }
            });
        }
    }

    private final void c(boolean isSuccess, long retCode, String errMsg, o9.f requestBean, ArrayList<String> batchId, a dataRepo) {
        if (isSuccess && retCode == 0) {
            if (dataRepo != null) {
                ArrayList<CommonStMedia> c16 = requestBean.c();
                String groupId = requestBean.getGroupId();
                if (groupId == null) {
                    groupId = "";
                }
                dataRepo.a(c16, groupId);
            }
            QQToast.makeText(BaseApplication.getContext(), 2, R.string.f1334162, 0).show();
            return;
        }
        RFWLog.e("QZoneIntimateDeleteMediaRepo", RFWLog.USR, "handleDeleteMediaResponse rsp error  isSuccess = " + isSuccess + " retCode = " + retCode + " errMsg = " + errMsg);
        if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ)) {
            ToastUtil.o(R.string.f1338579, 4);
        } else {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f1334061, 0).show();
        }
    }
}
