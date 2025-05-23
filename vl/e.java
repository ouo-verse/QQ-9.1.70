package vl;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.qzone.reborn.base.k;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import java.util.Map;
import tl.h;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e extends k {
    private static final String I = "e";
    private String C;
    private String D;
    private f E;
    private final Observer<? super Boolean> F = new a();
    private final View.OnClickListener G = new View.OnClickListener() { // from class: vl.b
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.this.K9(view);
        }
    };
    public View.OnClickListener H = new View.OnClickListener() { // from class: vl.c
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.this.L9(view);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private TextView f441820d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f441821e;

    /* renamed from: f, reason: collision with root package name */
    private QUIButton f441822f;

    /* renamed from: h, reason: collision with root package name */
    private String f441823h;

    /* renamed from: i, reason: collision with root package name */
    private String f441824i;

    /* renamed from: m, reason: collision with root package name */
    private String f441825m;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements Observer<Boolean> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            e.this.N9(bool);
        }
    }

    private void H9() {
        if (TextUtils.isEmpty(this.D)) {
            return;
        }
        RFWLog.d(I, RFWLog.USR, "bindReport mPublishReportId:" + this.D);
        fo.c.o(this.f441822f, this.D, new fo.b().h(new IDynamicParams() { // from class: vl.d
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map J9;
                J9 = e.this.J9(str);
                return J9;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0092, code lost:
    
        if (r0 != 3) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ Map J9(String str) {
        int currentImageUploadQuality;
        HashMap hashMap = new HashMap();
        if (!getHostFragment().isAdded()) {
            return hashMap;
        }
        h hVar = (h) getViewModel(h.class);
        int i3 = 1;
        if (hVar != null && hVar.Q1() != null) {
            int i16 = 0;
            int i17 = 0;
            for (LocalMediaInfo localMediaInfo : hVar.Q1().values()) {
                if (QAlbumUtil.getMediaType(localMediaInfo) == 0) {
                    i16++;
                } else if (QAlbumUtil.getMediaType(localMediaInfo) == 1) {
                    i17++;
                }
            }
            hashMap.put("pic_cnt", Integer.valueOf(i16));
            hashMap.put("video_number", Integer.valueOf(i17));
        }
        com.qzone.reborn.part.publish.common.inputarea.d dVar = (com.qzone.reborn.part.publish.common.inputarea.d) getViewModel(com.qzone.reborn.part.publish.common.inputarea.d.class);
        if (dVar != null) {
            hashMap.put("is_without_text", Integer.valueOf(!TextUtils.isEmpty(dVar.U1()) ? 1 : 0));
        }
        qc.b bVar = (qc.b) getViewModel(qc.b.class);
        if (bVar != null && (currentImageUploadQuality = bVar.getCurrentImageUploadQuality()) != 0) {
            if (currentImageUploadQuality == 2) {
                i3 = 2;
            }
            hashMap.put("finnal_pic_quality", Integer.valueOf(i3));
            hashMap.put("publisher_gameplay", broadcastGetMessage("get_publisher_game_play_record", null));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EDIT_PAGE_GAMEPLAY, broadcastGetMessage("get_publisher_editor_game_play_record", null));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.IS_SHARE_ORIGINAL_PICTURE, broadcastGetMessage("get_is_share_original_picture", null));
            return hashMap;
        }
        i3 = 3;
        hashMap.put("finnal_pic_quality", Integer.valueOf(i3));
        hashMap.put("publisher_gameplay", broadcastGetMessage("get_publisher_game_play_record", null));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EDIT_PAGE_GAMEPLAY, broadcastGetMessage("get_publisher_editor_game_play_record", null));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.IS_SHARE_ORIGINAL_PICTURE, broadcastGetMessage("get_is_share_original_picture", null));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Activity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        String str = I;
        RFWLog.d(str, RFWLog.USR, "publish btn click");
        if (!FastClickUtils.isFastDoubleClick(str)) {
            broadcastMessage("publish_btn_clk", null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N9(Boolean bool) {
        QUIButton qUIButton = this.f441822f;
        if (qUIButton == null) {
            return;
        }
        qUIButton.setEnabled(bool.booleanValue());
    }

    public void G9(String str) {
        this.C = str;
    }

    public void I9(String str) {
        this.D = str;
    }

    public void M9(String str) {
        this.f441824i = str;
    }

    public void O9(String str) {
        this.f441825m = str;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return I;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        View findViewById = view.findViewById(R.id.f67813ec);
        this.f441820d = (TextView) findViewById.findViewById(R.id.f67823ed);
        if (!TextUtils.isEmpty(this.f441823h)) {
            this.f441820d.setText(this.f441823h);
        }
        this.f441820d.setOnClickListener(this.G);
        if (!TextUtils.isEmpty(this.C)) {
            RFWLog.d(I, RFWLog.USR, "bindReport mCancelReportId:" + this.C);
            fo.c.o(this.f441820d, this.C, null);
        }
        this.f441821e = (TextView) findViewById.findViewById(R.id.f67843ef);
        if (!TextUtils.isEmpty(this.f441825m)) {
            this.f441821e.setText(this.f441825m);
        }
        this.f441822f = (QUIButton) findViewById.findViewById(R.id.f67833ee);
        if (!TextUtils.isEmpty(this.f441824i)) {
            this.f441822f.setText(this.f441824i);
        }
        this.f441822f.setOnClickListener(this.H);
        H9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        f fVar = (f) getViewModel(f.class);
        this.E = fVar;
        fVar.O1().observe(getPartHost().getLifecycleOwner(), this.F);
    }
}
