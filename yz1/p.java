package yz1;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingQrCodeViewModel;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.widget.share.ShareActionSheetWithPreview;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\bZ\u0010[J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J0\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\tH\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\u000e\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fJ\u0016\u0010&\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$J\u000e\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010,\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010-\u001a\u0004\u0018\u00010\tJ\b\u0010.\u001a\u0004\u0018\u00010\tJ\u000e\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020/R\u0018\u00104\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010>R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010IR\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010U\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010TR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010X\u00a8\u0006\\"}, d2 = {"Lyz1/p;", "", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalInfoList", "", "name", "", "G", "Landroid/graphics/Bitmap;", "preview", "Ljava/io/File;", "file", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "u", "l", "o", "", "uinType", "uin", "snapshot", "filePath", UserInfo.SEX_FEMALE, "Landroid/app/Activity;", "curActivity", "preView", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetWithPreview;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "shareActionSheet", "p", "Landroid/view/View;", "shareLayout", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingQrCodeViewModel;", "mViewModel", "v", "url", "w", "info", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "D", "r", "I", "", "isCacheFile", DomainData.DOMAIN_NAME, "a", "Landroid/graphics/Bitmap;", "snapshotBitmap", "b", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingQrCodeViewModel;", "viewModel", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "guildIcon", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "guildName", "e", "guildStrNumber", "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "f", "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "guildQrCode", "g", "Landroid/view/View;", tl.h.F, "Ljava/lang/String;", "shareInfo", "i", "qrCodeUrl", "j", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "Lcom/tencent/mobileqq/guild/share/q;", "k", "Lcom/tencent/mobileqq/guild/share/q;", "shareDtReportHelper", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$m;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$m;", "itemRender", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$l;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$l;", "dialogRender", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap snapshotBitmap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private GuildSettingQrCodeViewModel viewModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ImageView guildIcon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView guildName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView guildStrNumber;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUIColorfulQRCodeView guildQrCode;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View shareLayout;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProGuildInfo guildInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String shareInfo = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String qrCodeUrl = "";

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.share.q shareDtReportHelper = new com.tencent.mobileqq.guild.share.q();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ShareActionSheetV2.m itemRender = new ShareActionSheetV2.m() { // from class: yz1.l
        @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2.m
        public final void a(View view, ImageView imageView, TextView textView, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
            p.z(p.this, view, imageView, textView, actionSheetItem);
        }
    };

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ShareActionSheetV2.l dialogRender = new ShareActionSheetV2.l() { // from class: yz1.m
        @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2.l
        public final void b(ActionSheet actionSheet) {
            p.m(p.this, actionSheet);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"yz1/p$b", "Lcom/tencent/mobileqq/sharepanel/j;", "", "channelId", "", "a", "actionId", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.sharepanel.j {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f451645b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bitmap f451646c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ File f451647d;

        b(FragmentActivity fragmentActivity, Bitmap bitmap, File file) {
            this.f451645b = fragmentActivity;
            this.f451646c = bitmap;
            this.f451647d = file;
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void a(@NotNull String channelId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            switch (channelId.hashCode()) {
                case -791575966:
                    if (channelId.equals("weixin")) {
                        String absolutePath = this.f451647d.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                        m02.d.q(absolutePath, this.f451646c);
                        return;
                    }
                    return;
                case -393543490:
                    if (channelId.equals("qqfriend")) {
                        FragmentActivity fragmentActivity = this.f451645b;
                        String absolutePath2 = this.f451647d.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath2, "file.absolutePath");
                        m02.d.n(fragmentActivity, absolutePath2, false, 4, null);
                        return;
                    }
                    return;
                case -304161157:
                    if (channelId.equals("qzoneshuoshuo")) {
                        FragmentActivity fragmentActivity2 = this.f451645b;
                        String absolutePath3 = this.f451647d.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath3, "file.absolutePath");
                        m02.d.u(fragmentActivity2, absolutePath3);
                        return;
                    }
                    return;
                case 3367071:
                    if (channelId.equals("mypc")) {
                        p pVar = p.this;
                        FragmentActivity fragmentActivity3 = this.f451645b;
                        String DATALINE_PC_UIN = AppConstants.DATALINE_PC_UIN;
                        Intrinsics.checkNotNullExpressionValue(DATALINE_PC_UIN, "DATALINE_PC_UIN");
                        Bitmap bitmap = this.f451646c;
                        String absolutePath4 = this.f451647d.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath4, "file.absolutePath");
                        pVar.F(fragmentActivity3, 6000, DATALINE_PC_UIN, bitmap, absolutePath4);
                        return;
                    }
                    return;
                case 154627506:
                    if (channelId.equals("weixincircle")) {
                        String absolutePath5 = this.f451647d.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath5, "file.absolutePath");
                        m02.d.r(absolutePath5, this.f451646c);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void b(@NotNull String actionId) {
            Intrinsics.checkNotNullParameter(actionId, "actionId");
            if (Intrinsics.areEqual(actionId, WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK)) {
                p.this.l(this.f451645b);
                return;
            }
            if (Intrinsics.areEqual(actionId, "save_to_phone")) {
                GuildSettingQrCodeViewModel guildSettingQrCodeViewModel = p.this.viewModel;
                if (guildSettingQrCodeViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    guildSettingQrCodeViewModel = null;
                }
                guildSettingQrCodeViewModel.c2(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(File file, Bitmap preview) {
        Intrinsics.checkNotNullParameter(file, "$file");
        Intrinsics.checkNotNullParameter(preview, "$preview");
        if (!com.tencent.mobileqq.guild.util.p.d(file, preview)) {
            QLog.e("GuildQRCodeShareHelper", 1, "handlePlatformShareClick writeBitmapToFile error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(p this$0, FragmentActivity activity, Bitmap preview, File file, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(preview, "$preview");
        Intrinsics.checkNotNullParameter(file, "$file");
        shareActionSheet.dismiss();
        QLog.i("GuildQRCodeShareHelper", 1, "click action=" + actionSheetItem.action);
        int i3 = actionSheetItem.action;
        if (i3 != 1) {
            GuildSettingQrCodeViewModel guildSettingQrCodeViewModel = null;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9) {
                        if (i3 != 10) {
                            if (i3 != 26) {
                                if (i3 == 39) {
                                    GuildSettingQrCodeViewModel guildSettingQrCodeViewModel2 = this$0.viewModel;
                                    if (guildSettingQrCodeViewModel2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    } else {
                                        guildSettingQrCodeViewModel = guildSettingQrCodeViewModel2;
                                    }
                                    guildSettingQrCodeViewModel.c2(true);
                                    return;
                                }
                                return;
                            }
                            String DATALINE_PC_UIN = AppConstants.DATALINE_PC_UIN;
                            Intrinsics.checkNotNullExpressionValue(DATALINE_PC_UIN, "DATALINE_PC_UIN");
                            String absolutePath = file.getAbsolutePath();
                            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                            this$0.F(activity, 6000, DATALINE_PC_UIN, preview, absolutePath);
                            return;
                        }
                        String absolutePath2 = file.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath2, "file.absolutePath");
                        m02.d.r(absolutePath2, preview);
                        return;
                    }
                    String absolutePath3 = file.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath3, "file.absolutePath");
                    m02.d.q(absolutePath3, preview);
                    return;
                }
                String absolutePath4 = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath4, "file.absolutePath");
                m02.d.u(activity, absolutePath4);
                return;
            }
            String absolutePath5 = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath5, "file.absolutePath");
            m02.d.n(activity, absolutePath5, false, 4, null);
            return;
        }
        this$0.l(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(File file, Bitmap preview) {
        Intrinsics.checkNotNullParameter(file, "$file");
        Intrinsics.checkNotNullParameter(preview, "$preview");
        if (!com.tencent.mobileqq.guild.util.p.d(file, preview)) {
            QLog.e("GuildQRCodeShareHelper", 1, "handlePlatformShareClick writeBitmapToFile error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(FragmentActivity activity, int uinType, String uin, Bitmap snapshot, String filePath) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, filePath);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, filePath);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, filePath);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, filePath);
        bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        bundle.putInt("key_direct_show_uin_type", uinType);
        bundle.putString("key_direct_show_uin", uin);
        if (6000 == uinType && AppConstants.DATALINE_PC_UIN == uin) {
            bundle.putBoolean("filepath_copy", true);
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startForwardActivityForResult(activity, intent, 21, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "biz_src_jc_gxl_ctcshare");
    }

    private final void G(final List<? extends IGProMedalInfo> medalInfoList, final String name) {
        if (q.f451648a.e(new ArrayList(medalInfoList)).isEmpty()) {
            return;
        }
        TextView textView = this.guildName;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildName");
            textView = null;
        }
        textView.setText(name);
        TextView textView3 = this.guildName;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildName");
        } else {
            textView2 = textView3;
        }
        textView2.post(new Runnable() { // from class: yz1.n
            @Override // java.lang.Runnable
            public final void run() {
                p.H(name, medalInfoList, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(String name, List medalInfoList, p this$0) {
        Intrinsics.checkNotNullParameter(name, "$name");
        Intrinsics.checkNotNullParameter(medalInfoList, "$medalInfoList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildMedalUtils guildMedalUtils = GuildMedalUtils.f235347a;
        TextView textView = this$0.guildName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildName");
            textView = null;
        }
        GuildMedalUtils.w(guildMedalUtils, name, medalInfoList, textView, null, 0, null, 56, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(FragmentActivity activity) {
        Object systemService = activity.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("group_pro_url", o()));
        QQToast.makeText(activity, 2, "\u590d\u5236\u6210\u529f", 0).show(R.dimen.title_bar_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(p this$0, ActionSheet actionSheet) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.share.q qVar = this$0.shareDtReportHelper;
        GuildSharePageSource guildSharePageSource = GuildSharePageSource.GUILD_QR_CODE;
        IGProGuildInfo iGProGuildInfo = this$0.guildInfo;
        if (iGProGuildInfo != null) {
            str = iGProGuildInfo.getGuildID();
        } else {
            str = null;
        }
        com.tencent.mobileqq.guild.share.q.d(qVar, actionSheet, guildSharePageSource, str, null, null, 16, null);
    }

    private final String o() {
        String str;
        if (!TextUtils.isEmpty(this.shareInfo)) {
            return this.shareInfo;
        }
        Object[] objArr = new Object[2];
        IGProGuildInfo iGProGuildInfo = this.guildInfo;
        if (iGProGuildInfo != null) {
            str = iGProGuildInfo.getGuildName();
        } else {
            str = null;
        }
        objArr[0] = str;
        objArr[1] = this.qrCodeUrl;
        String s16 = QQGuildUIUtil.s(R.string.f156751l2, objArr);
        Intrinsics.checkNotNullExpressionValue(s16, "getString(\n            R\u2026      qrCodeUrl\n        )");
        return s16;
    }

    private final void p(ShareActionSheetWithPreview shareActionSheet) {
        ArrayList arrayList = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(26);
        Intrinsics.checkNotNullExpressionValue(build, "build(ShareActionSheetBu\u2026etItem.ACTION_SEND_TO_PC)");
        arrayList.add(build);
        ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(2);
        Intrinsics.checkNotNullExpressionValue(build2, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_FRIEND)");
        arrayList.add(build2);
        ShareActionSheetBuilder.ActionSheetItem build3 = ShareActionSheetBuilder.ActionSheetItem.build(3);
        Intrinsics.checkNotNullExpressionValue(build3, "build(ShareActionSheetBu\u2026tem.ACTION_SEND_TO_QZONE)");
        arrayList.add(build3);
        QLog.d("GuildQRCodeShareHelper", 1, " getShareActionSheet isWxInstalled " + m02.d.i());
        if (m02.d.i()) {
            ShareActionSheetBuilder.ActionSheetItem build4 = ShareActionSheetBuilder.ActionSheetItem.build(9);
            Intrinsics.checkNotNullExpressionValue(build4, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_WECHAT)");
            arrayList.add(build4);
            ShareActionSheetBuilder.ActionSheetItem build5 = ShareActionSheetBuilder.ActionSheetItem.build(10);
            Intrinsics.checkNotNullExpressionValue(build5, "build(ShareActionSheetBu\u2026ON_SEND_TO_WECHAT_CIRCLE)");
            arrayList.add(build5);
        }
        ArrayList arrayList2 = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build6 = ShareActionSheetBuilder.ActionSheetItem.build(39);
        Intrinsics.checkNotNullExpressionValue(build6, "build(ShareActionSheetBu\u2026ionSheetItem.ACTION_SAVE)");
        arrayList2.add(build6);
        ShareActionSheetBuilder.ActionSheetItem build7 = ShareActionSheetBuilder.ActionSheetItem.build(1);
        Intrinsics.checkNotNullExpressionValue(build7, "build(ShareActionSheetBu\u2026heetItem.ACTION_COPYLINK)");
        arrayList2.add(build7);
        shareActionSheet.setActionSheetItems(arrayList, arrayList2);
        this.shareDtReportHelper.e(arrayList2);
    }

    private final ShareActionSheetWithPreview q(Activity curActivity, Bitmap preView) {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        curActivity.getIntent().putExtra("big_brother_source_key", "guild_share");
        param.canceledOnTouchOutside = true;
        param.context = curActivity;
        param.fullScreen = true;
        param.f317475lp = new ViewGroup.LayoutParams(-1, -2);
        param.actionSheetRender = this.dialogRender;
        param.itemRender = this.itemRender;
        ShareActionSheetWithPreview shareActionSheetWithPreview = new ShareActionSheetWithPreview(param);
        shareActionSheetWithPreview.D0(preView);
        Intent intent = new Intent();
        intent.putExtra("forward_type", 27);
        shareActionSheetWithPreview.setIntentForStartForwardRecentActivity(intent);
        shareActionSheetWithPreview.setRowVisibility(8, 0, 0);
        shareActionSheetWithPreview.setExtras(BundleKt.bundleOf(TuplesKt.to("no_need_report", Boolean.TRUE)));
        p(shareActionSheetWithPreview);
        return shareActionSheetWithPreview;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t() {
        QLog.i("GuildQRCodeShareHelper", 1, "OnFirstTimeDrawn");
    }

    private final void u(Bitmap preview, File file, FragmentActivity activity) {
        String str;
        com.tencent.mobileqq.sharepanel.f q06 = ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).createSharePanel(activity, "pindao_qrcode").s0().q0(preview);
        GuildSharePageSource guildSharePageSource = GuildSharePageSource.GUILD_QR_CODE;
        IGProGuildInfo iGProGuildInfo = this.guildInfo;
        if (iGProGuildInfo != null) {
            str = iGProGuildInfo.getGuildID();
        } else {
            str = null;
        }
        q06.d0(new com.tencent.mobileqq.guild.share.g(activity, guildSharePageSource, str, null, 8, null).b());
        if (!m02.d.i()) {
            q06.l0("weixin", false);
            q06.l0("weixincircle", false);
        }
        q06.t0(new b(activity, preview, file)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(int i3) {
        QLog.d("GuildQRCodeShareHelper", 1, "mIvQRCode.refreshContent: code:" + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(p this$0, View view, ImageView imageView, TextView nickView, ShareActionSheetBuilder.ActionSheetItem sheetItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.share.q qVar = this$0.shareDtReportHelper;
        Intrinsics.checkNotNullExpressionValue(nickView, "nickView");
        Intrinsics.checkNotNullExpressionValue(sheetItem, "sheetItem");
        qVar.a(view, imageView, nickView, sheetItem);
    }

    public final void A(@NotNull final FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        final Bitmap r16 = r();
        if (r16 == null) {
            ch.e1(1, "\u4e8c\u7ef4\u7801\u751f\u6210\u5931\u8d25");
            QLog.e("GuildQRCodeShareHelper", 1, "shareQRCode failed, bitmap is null");
            return;
        }
        final File n3 = n(true);
        ThreadManagerV2.excute(new Runnable() { // from class: yz1.i
            @Override // java.lang.Runnable
            public final void run() {
                p.B(n3, r16);
            }
        }, 64, null, true);
        ShareActionSheetWithPreview q16 = q(activity, r16);
        q16.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: yz1.j
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                p.C(p.this, activity, r16, n3, actionSheetItem, shareActionSheet);
            }
        });
        q16.show();
    }

    public final void D(@NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        final Bitmap r16 = r();
        if (r16 == null) {
            ch.e1(1, "\u4e8c\u7ef4\u7801\u751f\u6210\u5931\u8d25");
            QLog.e("GuildQRCodeShareHelper", 1, "shareQRCode failed, bitmap is null");
        } else {
            final File n3 = n(true);
            ThreadManagerV2.excute(new Runnable() { // from class: yz1.h
                @Override // java.lang.Runnable
                public final void run() {
                    p.E(n3, r16);
                }
            }, 64, null, true);
            u(r16, n3, activity);
        }
    }

    @Nullable
    public final Bitmap I() {
        View view = this.shareLayout;
        if (view == null) {
            QLog.e("GuildQRCodeShareHelper", 1, "createShareLayoutSnapshot failed, shareLayout null");
            return null;
        }
        if (view.getWidth() > 0 && view.getHeight() > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        QLog.e("GuildQRCodeShareHelper", 1, "createShareLayoutSnapshot failed, shareLayout size 0");
        return null;
    }

    @NotNull
    public final File n(boolean isCacheFile) {
        String sDKPrivatePath;
        String valueOf = String.valueOf(System.currentTimeMillis());
        if (isCacheFile) {
            sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath("cache/");
        } else {
            sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE);
        }
        File file = new File(sDKPrivatePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(sDKPrivatePath + "qq_guild_qrcode" + valueOf + ".jpg");
        int i3 = 2;
        while (file2.exists() && i3 < Integer.MAX_VALUE) {
            String str = AppConstants.SDCARD_IMG_SAVE + "qrcode_" + valueOf + "(" + i3 + ").jpg";
            Intrinsics.checkNotNullExpressionValue(str, "pathTmpBuilder.append(Ap\u2026              .toString()");
            i3++;
            file2 = new File(str);
        }
        return file2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
    
        if (r1 != false) goto L10;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bitmap r() {
        Bitmap bitmap = this.snapshotBitmap;
        if (bitmap != null) {
            boolean z16 = false;
            if (bitmap != null && bitmap.isRecycled()) {
                z16 = true;
            }
        }
        this.snapshotBitmap = I();
        return this.snapshotBitmap;
    }

    public final void s(@NotNull View shareLayout) {
        Intrinsics.checkNotNullParameter(shareLayout, "shareLayout");
        View findViewById = shareLayout.findViewById(R.id.x0n);
        Intrinsics.checkNotNullExpressionValue(findViewById, "shareLayout.findViewById\u2026d.guild_share_str_number)");
        this.guildStrNumber = (TextView) findViewById;
        View findViewById2 = shareLayout.findViewById(R.id.x0h);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "shareLayout.findViewById(R.id.guild_share_name)");
        this.guildName = (TextView) findViewById2;
        View findViewById3 = shareLayout.findViewById(R.id.x0a);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "shareLayout.findViewById\u2026id.guild_share_icon_head)");
        this.guildIcon = (ImageView) findViewById3;
        View findViewById4 = shareLayout.findViewById(R.id.x0l);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "shareLayout.findViewById(R.id.guild_share_qr_code)");
        QUIColorfulQRCodeView qUIColorfulQRCodeView = (QUIColorfulQRCodeView) findViewById4;
        this.guildQrCode = qUIColorfulQRCodeView;
        QUIColorfulQRCodeView qUIColorfulQRCodeView2 = null;
        if (qUIColorfulQRCodeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildQrCode");
            qUIColorfulQRCodeView = null;
        }
        QUIColorfulQRCodeView.o(qUIColorfulQRCodeView, -16776961, null, 2, null);
        QUIColorfulQRCodeView qUIColorfulQRCodeView3 = this.guildQrCode;
        if (qUIColorfulQRCodeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildQrCode");
            qUIColorfulQRCodeView3 = null;
        }
        qUIColorfulQRCodeView3.g(new com.tencent.mobileqq.component.qrcode.i(R.drawable.guild_qrcode_logo, null, null, 0));
        QUIColorfulQRCodeView qUIColorfulQRCodeView4 = this.guildQrCode;
        if (qUIColorfulQRCodeView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildQrCode");
        } else {
            qUIColorfulQRCodeView2 = qUIColorfulQRCodeView4;
        }
        qUIColorfulQRCodeView2.setOnFirstTimeDrawnListener(new com.tencent.mobileqq.component.qrcode.h() { // from class: yz1.k
            @Override // com.tencent.mobileqq.component.qrcode.h
            public final void a() {
                p.t();
            }
        });
        this.shareLayout = shareLayout;
    }

    public final void v(@NotNull IGProGuildInfo guildInfo, @NotNull GuildSettingQrCodeViewModel mViewModel) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        this.viewModel = mViewModel;
        this.guildInfo = guildInfo;
        TextView textView = this.guildStrNumber;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildStrNumber");
            textView = null;
        }
        textView.setText("\u9891\u9053\u53f7: " + guildInfo.getGuildNumber());
        TextView textView2 = this.guildName;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildName");
            textView2 = null;
        }
        textView2.setText(guildInfo.getGuildName());
        ArrayList<IGProMedalInfo> medalInfoList = guildInfo.getMedalInfoList();
        Intrinsics.checkNotNullExpressionValue(medalInfoList, "guildInfo.medalInfoList");
        String guildName = guildInfo.getGuildName();
        Intrinsics.checkNotNullExpressionValue(guildName, "guildInfo.guildName");
        G(medalInfoList, guildName);
        String avatarUrl = guildInfo.getAvatarUrl(140);
        Intrinsics.checkNotNullExpressionValue(avatarUrl, "guildInfo.getAvatarUrl(I\u2026ldAvatarUrlType.SIZE_140)");
        if (TextUtils.isEmpty(avatarUrl)) {
            ImageView imageView2 = this.guildIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildIcon");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView3 = this.guildIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildIcon");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        ImageView imageView4 = this.guildIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildIcon");
            imageView4 = null;
        }
        Drawable J = ch.J(avatarUrl, Utils.n(61.0f, imageView4.getContext().getResources()), BaseImageUtil.getDefaultFaceDrawable(false), false);
        ImageView imageView5 = this.guildIcon;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildIcon");
        } else {
            imageView = imageView5;
        }
        imageView.setImageDrawable(J);
    }

    public final void w(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.qrCodeUrl = url;
        QUIColorfulQRCodeView qUIColorfulQRCodeView = this.guildQrCode;
        if (qUIColorfulQRCodeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildQrCode");
            qUIColorfulQRCodeView = null;
        }
        qUIColorfulQRCodeView.f(url, new com.tencent.mobileqq.component.qrcode.g() { // from class: yz1.o
            @Override // com.tencent.mobileqq.component.qrcode.g
            public final void onResult(int i3) {
                p.x(i3);
            }
        });
    }

    public final void y(@NotNull String info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.shareInfo = info;
    }
}
