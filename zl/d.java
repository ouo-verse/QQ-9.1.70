package zl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.qzone.common.friend.business.model.Friend;
import com.qzone.reborn.base.k;
import com.qzone.reborn.intimate.request.QZoneIntimateIsSyncRequest;
import com.qzone.util.ac;
import com.qzone.widget.MoodPicLabel;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.api.QZoneContant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import qzone.QZIntimateSpaceWriter$StIsQzoneSyncIntimateRsp;
import rn.h;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d extends k {

    /* renamed from: d, reason: collision with root package name */
    private MoodPicLabel f452722d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f452723e;

    /* renamed from: f, reason: collision with root package name */
    private fm.b f452724f;

    private void F9(String str, List<Friend> list) {
        if (!G9()) {
            QLog.d("QzoneAtFriendPart", 1, "[checkIntimateAndShowToast] enableShowAtUserToast return false");
            return;
        }
        if (!ac.c()) {
            QLog.d("QzoneAtFriendPart", 1, "[checkIntimateAndShowToast] not open intimate space");
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                Friend friend = list.get(i3);
                if (friend != null) {
                    arrayList.add(friend.mUin + "");
                }
            }
        }
        final QZoneIntimateIsSyncRequest qZoneIntimateIsSyncRequest = new QZoneIntimateIsSyncRequest(str, arrayList);
        VSNetworkHelper.getInstance().sendRequest(qZoneIntimateIsSyncRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: zl.c
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                d.this.H9(qZoneIntimateIsSyncRequest, baseRequest, z16, j3, str2, (QZIntimateSpaceWriter$StIsQzoneSyncIntimateRsp) obj);
            }
        });
    }

    private boolean G9() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_INTIMATE_ENABLE_SHOW_AT_TOAST, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H9(QZoneIntimateIsSyncRequest qZoneIntimateIsSyncRequest, BaseRequest baseRequest, boolean z16, long j3, String str, QZIntimateSpaceWriter$StIsQzoneSyncIntimateRsp qZIntimateSpaceWriter$StIsQzoneSyncIntimateRsp) {
        RFWLog.d("QzoneAtFriendPart", RFWLog.USR, "[checkIntimateAndShowToast] traceId: " + qZoneIntimateIsSyncRequest.getTraceId() + ", isSuccess: " + z16 + ", retCode: " + j3 + ", errMsg: " + str);
        if ((z16 && j3 == 0 && qZIntimateSpaceWriter$StIsQzoneSyncIntimateRsp != null) && qZIntimateSpaceWriter$StIsQzoneSyncIntimateRsp.is_sync.get()) {
            this.f452723e = true;
            QLog.d("QzoneAtFriendPart", 1, "[checkIntimateAndShowToast] show sync " + qZIntimateSpaceWriter$StIsQzoneSyncIntimateRsp.f430332msg.get());
            QQToast.makeText(BaseApplication.getContext(), 5, qZIntimateSpaceWriter$StIsQzoneSyncIntimateRsp.f430332msg.get(), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.d("QzoneAtFriendPart", 1, "on click at");
        L9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J9() {
        QLog.d("QzoneAtFriendPart", 1, "[tryShowGuidePop] real show");
        if (getContext() == null) {
            return;
        }
        QUIDefaultBubbleTip.r(getContext()).S(this.f452722d).m0(3).o0(RFWApplication.getApplication().getString(R.string.w_a)).R(0).g0(false).k0(0).s0();
        HashMap hashMap = new HashMap();
        hashMap.put("qq_eid", "em_qz_friends_tag");
        hashMap.put("qq_pgid", "pg_qz_space_says_publish");
        fo.c.c("ev_qzone_abnormal_imp", hashMap);
        LocalMultiProcConfig.putBool("PUBLISH_HAVE_SHOW_INTIMATE_AT_TEST_GUIDE", true);
    }

    private void L9() {
        Intent intent = new Intent();
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, QZoneConfigHelper.M());
        Activity activity = getActivity();
        if (activity instanceof BasePluginActivity) {
            activity = ((BasePluginActivity) activity).getOutActivity();
        }
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(activity, intent, QZoneContant.QZ_SEARCH_LOCAL_REQUEST_CODE);
    }

    private void M9() {
        if (!ac.c()) {
            QLog.d("QzoneAtFriendPart", 1, "[tryShowGuidePop] not open intimate space");
        } else if (LocalMultiProcConfig.getBool("PUBLISH_HAVE_SHOW_INTIMATE_AT_TEST_GUIDE", false)) {
            QLog.d("QzoneAtFriendPart", 1, "[tryShowGuidePop] have show guide");
        } else {
            this.f452722d.postDelayed(new Runnable() { // from class: zl.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.J9();
                }
            }, 1500L);
        }
    }

    public void K9(String str, List<Friend> list) {
        if (!ac.c()) {
            QLog.d("QzoneAtFriendPart", 1, "[onAtListChange] not open intimate space");
        } else {
            if (TextUtils.isEmpty(str) || this.f452723e) {
                return;
            }
            F9(str, list);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f452724f = (fm.b) getViewModel(fm.b.class);
        MoodPicLabel moodPicLabel = (MoodPicLabel) view.findViewById(R.id.zff);
        this.f452722d = moodPicLabel;
        h.a(moodPicLabel.a(), "qui_at", R.color.qui_common_text_secondary);
        this.f452722d.setOnClickListener(new View.OnClickListener() { // from class: zl.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.this.I9(view2);
            }
        });
        if (this.f452724f.S1()) {
            this.f452722d.setVisibility(8);
        } else {
            this.f452722d.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        M9();
    }
}
