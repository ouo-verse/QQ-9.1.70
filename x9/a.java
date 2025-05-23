package x9;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.albumx.common.bean.e;
import com.qzone.reborn.base.l;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.widget.PercentProgressBar;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.queue.DownloadState;
import com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener;
import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class a extends l<e> implements View.OnClickListener, RFWDownloadQueueResultListener {
    private ImageView C;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f447480e;

    /* renamed from: f, reason: collision with root package name */
    private RoundCornerImageView f447481f;

    /* renamed from: h, reason: collision with root package name */
    private QZoneRichTextView f447482h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f447483i;

    /* renamed from: m, reason: collision with root package name */
    private PercentProgressBar f447484m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: x9.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static /* synthetic */ class C11534a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f447485a;

        static {
            int[] iArr = new int[DownloadState.values().length];
            f447485a = iArr;
            try {
                iArr[DownloadState.STATE_WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f447485a[DownloadState.STATE_START_RUN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f447485a[DownloadState.STATE_RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f447485a[DownloadState.STATE_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f447485a[DownloadState.STATE_SUCCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f447485a[DownloadState.STATE_CANCEL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f447485a[DownloadState.STATE_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private String u(e eVar) {
        if (eVar == null) {
            return "";
        }
        switch (C11534a.f447485a[eVar.getStateData().getState().ordinal()]) {
            case 1:
                return "\u6392\u961f\u4e2d";
            case 2:
            case 3:
                return "\u6b63\u5728\u4e0b\u8f7d\uff1a" + ((int) (eVar.getStateData().getPercent() * 100.0f)) + "%";
            case 4:
                return "\u5df2\u505c\u6b62\u4e0b\u8f7d";
            case 5:
                return "\u4e0b\u8f7d\u5b8c\u6210";
            case 6:
                return "\u4e0b\u8f7d\u5df2\u53d6\u6d88";
            case 7:
                return "\u4e0b\u8f7d\u5931\u8d25";
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean v(e eVar) {
        return eVar.getStateData().getState() == DownloadState.STATE_PAUSE || eVar.getStateData().getState() == DownloadState.STATE_ERROR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w(e eVar) {
        return eVar.getStateData().getState() == DownloadState.STATE_WAITING || eVar.getStateData().getState() == DownloadState.STATE_START_RUN || eVar.getStateData().getState() == DownloadState.STATE_RUNNING;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onBindData(e eVar, int i3, List<Object> list) {
        y(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.n5x};
    }

    private void y(e eVar) {
        String str;
        if (eVar == null) {
            QLog.e(getTAG(), 1, "[onBindData] bean is null");
            return;
        }
        if (eVar.getStateData().getExtMap() != null) {
            this.f447482h.setRichText(eVar.getStateData().getExtMap().get("ext_key_task_desc"));
            if (TextUtils.equals(eVar.getStateData().getExtMap().get("ext_key_is_video"), "1")) {
                this.f447480e.setVisibility(0);
                str = eVar.getStateData().getExtMap().get("ext_key_video_url");
            } else {
                this.f447480e.setVisibility(8);
                str = eVar.getStateData().getUrl();
            }
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            c.a().h(Option.obtain().setUrl(str).setTargetView(this.f447481f).setLoadingDrawableId(R.drawable.asd).setFailedDrawableId(R.drawable.asd));
        }
        z(eVar);
        if (v(eVar)) {
            fo.c.o(this.C, "em_qz_download_continue", new fo.b().i(String.valueOf(eVar.getStateData().getUrl().hashCode())));
        } else {
            fo.c.o(this.C, "em_qz_pause", new fo.b().i(String.valueOf(eVar.getStateData().getUrl().hashCode())));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener
    public void onStateChange(RFWDownloadTaskStateData rFWDownloadTaskStateData) {
        if (rFWDownloadTaskStateData != null && TextUtils.equals(rFWDownloadTaskStateData.getBusinessKey(), ((e) this.mData).getStateData().getBusinessKey()) && TextUtils.equals(rFWDownloadTaskStateData.getUrl(), ((e) this.mData).getStateData().getUrl())) {
            ((e) this.mData).b(rFWDownloadTaskStateData);
            z((e) this.mData);
        }
    }

    private void z(e eVar) {
        if (eVar == null) {
            return;
        }
        this.f447483i.setText(u(eVar));
        if (eVar.getStateData().getState() != DownloadState.STATE_WAITING && eVar.getStateData().getState() != DownloadState.STATE_START_RUN) {
            if (eVar.getStateData().getState() != DownloadState.STATE_RUNNING && eVar.getStateData().getState() != DownloadState.STATE_PAUSE) {
                this.f447484m.setVisibility(4);
            } else {
                this.f447484m.setProgress((int) (eVar.getStateData().getPercent() * 100.0f));
                this.f447484m.setVisibility(0);
            }
        } else {
            this.f447484m.setProgress(0);
            this.f447484m.setVisibility(0);
        }
        this.C.setVisibility(8);
        if (v(eVar)) {
            this.C.setImageResource(R.drawable.qui_download);
            this.C.setVisibility(0);
        } else if (w(eVar)) {
            this.C.setImageResource(R.drawable.qui_pause_filled);
            this.C.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        this.f447480e = (ImageView) view.findViewById(R.id.lvx);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) view.findViewById(R.id.ngk);
        this.f447481f = roundCornerImageView;
        roundCornerImageView.setCorner(cx.a(4.0f));
        this.f447482h = (QZoneRichTextView) view.findViewById(R.id.ngo);
        this.f447483i = (TextView) view.findViewById(R.id.ngl);
        this.f447484m = (PercentProgressBar) view.findViewById(R.id.ngn);
        ImageView imageView = (ImageView) view.findViewById(R.id.ngm);
        this.C = imageView;
        imageView.setImageResource(R.drawable.qui_download);
        this.C.setOnClickListener(this);
    }
}
