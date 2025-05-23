package xd;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.text.ColorTextCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellParser;
import com.qzone.proxy.feedcomponent.text.TopicTextCell;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.util.w;
import com.qzone.util.am;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellOrigin;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellUserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicSpecUrlEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtilKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a%\u0010\u0007\u001a\u00020\u0001*\u00020\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u000e\u001a\u00020\u0001*\u00020\t2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n\u00a2\u0006\u0002\b\f\u001a*\u0010\u0015\u001a\u00020\u0014*\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u001a\f\u0010\u0017\u001a\u00020\u0014*\u0004\u0018\u00010\u0016\u001a\f\u0010\u0018\u001a\u00020\u0014*\u0004\u0018\u00010\u0016\u001a\f\u0010\u0019\u001a\u00020\u0014*\u0004\u0018\u00010\u0016\u001a\f\u0010\u001a\u001a\u00020\u0014*\u0004\u0018\u00010\u000f\u001a\f\u0010\u001c\u001a\u00020\u0014*\u0004\u0018\u00010\u001b\u001a\f\u0010\u001d\u001a\u00020\u0014*\u0004\u0018\u00010\u000f\u001a\f\u0010\u001e\u001a\u00020\u0014*\u0004\u0018\u00010\u000f\u001a\f\u0010\u001f\u001a\u00020\u0014*\u0004\u0018\u00010\u000f\u001a\f\u0010 \u001a\u00020\u0014*\u0004\u0018\u00010\u000f\u001a\f\u0010!\u001a\u00020\u0014*\u0004\u0018\u00010\u001b\u001a\f\u0010\"\u001a\u00020\u0014*\u0004\u0018\u00010\u000f\u001a\f\u0010#\u001a\u00020\u0014*\u0004\u0018\u00010\u000f\u001a\f\u0010$\u001a\u00020\u0014*\u0004\u0018\u00010\u000f\u001a\f\u0010&\u001a\u00020%*\u0004\u0018\u00010\u000f\u001a*\u0010,\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'*\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u0014\u001a*\u0010-\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'*\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u0014\u001a\u000e\u0010/\u001a\u0004\u0018\u00010.*\u0004\u0018\u00010\u000f\u001a\f\u00100\u001a\u00020\u0014*\u0004\u0018\u00010\u000f\u001a\f\u00101\u001a\u00020\u0014*\u0004\u0018\u00010\u000f\u001a\f\u00103\u001a\u00020%*\u0004\u0018\u000102\u001a\f\u00104\u001a\u00020\u0014*\u0004\u0018\u00010\u000f\u001a\"\u00109\u001a\u00020\u00012\b\u00106\u001a\u0004\u0018\u0001052\b\u00107\u001a\u0004\u0018\u00010%2\u0006\u00108\u001a\u00020)\u001a\u000e\u0010<\u001a\u00020)2\u0006\u0010;\u001a\u00020:\u001a\u000e\u0010>\u001a\u0004\u0018\u00010=*\u0004\u0018\u00010\u000f\u00a8\u0006?"}, d2 = {"Landroid/widget/TextView;", "", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "", "Landroid/view/View;", "views", "b", "(Landroid/view/ViewGroup;[Landroid/view/View;)V", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/Function1;", "Landroidx/constraintlayout/widget/ConstraintSet;", "Lkotlin/ExtensionFunctionType;", "block", "c", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "view", "feedData", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ReportConstant.COSTREPORT_PREFIX, "y", "e", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellMedia;", "d", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "v", HippyTKDListViewAdapter.X, "w", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "", "k", "", "Lcom/qzone/proxy/feedcomponent/text/TextCell;", "", "color", "isBold", "f", "g", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "l", "o", DomainData.DOMAIN_NAME, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonImage;", "i", "u", "Landroid/widget/ImageView;", "imageView", "token", "colorId", "D", "Landroid/content/Context;", "context", "j", "Lyd/a;", h.F, "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(CommonFeed commonFeed, View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.n0y) {
            am.a(TextCellParser.toPlainText(CommonFeedDataUtilKt.getFeedContentSummary(commonFeed)));
        } else {
            v3.getId();
        }
    }

    public static final void b(ViewGroup viewGroup, View... views) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(views, "views");
        for (View view : views) {
            viewGroup.addView(view);
        }
    }

    public static final void c(ConstraintLayout constraintLayout, Function1<? super ConstraintSet, Unit> block) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        block.invoke(constraintSet);
        constraintSet.applyTo(constraintLayout);
    }

    public static final int j(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return pl.a.f426446a.k(context) - ef.d.b(g.f53821a.b().Q0());
    }

    public static final String k(CommonFeed commonFeed) {
        Object obj;
        CommonUser user;
        String nick;
        CommonUser user2;
        String str = "";
        if (commonFeed == null) {
            return "";
        }
        CommonCellUserInfo cellUserInfo = commonFeed.getCellUserInfo();
        if (cellUserInfo == null || (user2 = cellUserInfo.getUser()) == null || (obj = user2.getUin()) == null) {
            obj = 0L;
        }
        CommonCellUserInfo cellUserInfo2 = commonFeed.getCellUserInfo();
        if (cellUserInfo2 != null && (user = cellUserInfo2.getUser()) != null && (nick = user.getNick()) != null) {
            str = nick;
        }
        String str2 = "<uin:" + obj + ",nickname:" + str + ">" + MsgSummary.STR_COLON;
        Intrinsics.checkNotNullExpressionValue(str2, "StringBuilder()\n        \u2026RD_USER_COLON).toString()");
        return str2;
    }

    public static final CommonUser l(CommonFeed commonFeed) {
        CommonCellUserInfo cellUserInfo;
        CommonCellOrigin cellOrigin;
        CommonCellUserInfo cellUserInfo2;
        if (!CommonFeedExtKt.isForwardFeed(commonFeed)) {
            if (commonFeed == null || (cellUserInfo = commonFeed.getCellUserInfo()) == null) {
                return null;
            }
            return cellUserInfo.getUser();
        }
        if (commonFeed == null || (cellOrigin = commonFeed.getCellOrigin()) == null || (cellUserInfo2 = cellOrigin.getCellUserInfo()) == null) {
            return null;
        }
        return cellUserInfo2.getUser();
    }

    public static final boolean A(CommonFeed commonFeed, View view, final CommonFeed commonFeed2, Activity activity) {
        if (view != null && commonFeed2 != null && activity != null) {
            if (CommonFeedExtKt.isAdFeed(commonFeed2)) {
                QLog.e("onContentLongClick", 1, "onContentLongClick ad feeds can not long click");
                return false;
            }
            com.tencent.biz.qqcircle.richframework.widget.menu.c cVar = new com.tencent.biz.qqcircle.richframework.widget.menu.c();
            cVar.a(R.id.n0y, HardCodeUtil.qqStr(R.string.rfw));
            w.a().b(view, cVar, new w.c() { // from class: xd.b
                @Override // com.qzone.reborn.feedx.util.w.c
                public final void onClick(View view2) {
                    c.B(CommonFeed.this, view2);
                }
            });
            return true;
        }
        QLog.e("onContentLongClick", 1, "onContentLongClick params error");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final List<TextCell> f(List<? extends TextCell> list, int i3, boolean z16) {
        if (ArrayUtils.isOutOfArrayIndex(0, list)) {
            return list;
        }
        Intrinsics.checkNotNull(list);
        for (TextCell textCell : list) {
            if (textCell instanceof UserNameCell) {
                ((UserNameCell) textCell).setTextBold(z16);
                textCell.setInnerLinkTextColor(i3);
            }
            if ((textCell instanceof ColorTextCell) && TextUtils.equals(textCell.text, MsgSummary.STR_COLON)) {
                ((ColorTextCell) textCell).setTextBold(z16);
                textCell.setInnerLinkTextColor(i3);
            }
        }
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final List<TextCell> g(List<? extends TextCell> list, int i3, boolean z16) {
        if (ArrayUtils.isOutOfArrayIndex(0, list)) {
            return list;
        }
        Intrinsics.checkNotNull(list);
        for (TextCell textCell : list) {
            if (textCell instanceof TopicTextCell) {
                ((TopicTextCell) textCell).setTextBold(z16);
                textCell.setInnerLinkTextColor(i3);
            }
        }
        return list;
    }

    public static final void C(TextView textView) {
        if (textView != null) {
            textView.setText("");
            textView.setVisibility(4);
        }
    }

    public static final void D(ImageView imageView, String str, int i3) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        c.C8489c g16 = new c.C8489c().h(str).f("").g(true);
        if (i3 != 0) {
            g16.e(i3);
        }
        com.tencent.mobileqq.qzone.picload.c.a().j(imageView, g16);
    }

    public static final yd.a h(CommonFeed commonFeed) {
        if (commonFeed != null) {
            return yd.c.f450161a.f(commonFeed);
        }
        return null;
    }

    public static final boolean d(CommonCellMedia commonCellMedia) {
        if (commonCellMedia != null) {
            Iterator<T> it = commonCellMedia.getMediaItems().iterator();
            while (it.hasNext()) {
                if (y((CommonMedia) it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean e(CommonFeed commonFeed) {
        CommonCellMedia cellMedia;
        if (commonFeed != null && (cellMedia = commonFeed.getCellMedia()) != null) {
            Iterator<T> it = cellMedia.getMediaItems().iterator();
            while (it.hasNext()) {
                if (y((CommonMedia) it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final String i(CommonImage commonImage) {
        List<CommonPicSpecUrlEntry> photoUrl;
        String c16;
        CommonPicUrl defaultUrl;
        String url;
        List<CommonPicSpecUrlEntry> photoUrl2;
        String c17 = (commonImage == null || (photoUrl2 = commonImage.getPhotoUrl()) == null) ? null : d.c(photoUrl2, 5);
        return c17 == null || c17.length() == 0 ? (commonImage == null || (defaultUrl = commonImage.getDefaultUrl()) == null || (url = defaultUrl.getUrl()) == null) ? "" : url : (commonImage == null || (photoUrl = commonImage.getPhotoUrl()) == null || (c16 = d.c(photoUrl, 5)) == null) ? "" : c16;
    }

    public static final boolean m(CommonFeed commonFeed) {
        return (commonFeed == null || !CommonFeedExtKt.isCommonDefaultFeed(commonFeed) || e(commonFeed) || TextUtils.isEmpty(CommonFeedDataUtilKt.getFeedContentSummary(commonFeed))) ? false : true;
    }

    public static final boolean o(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        return (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null || cellCommon.getUtime() <= cellCommon.getTime()) ? false : true;
    }

    public static final boolean p(CommonFeed commonFeed) {
        if (commonFeed == null || !CommonFeedExtKt.isCommonForwardFeed(commonFeed)) {
            return false;
        }
        CommonCellOrigin cellOrigin = commonFeed.getCellOrigin();
        return !d(cellOrigin != null ? cellOrigin.getCellMedia() : null);
    }

    public static final boolean q(CommonFeed commonFeed) {
        if (commonFeed == null || !CommonFeedExtKt.isCommonForwardFeed(commonFeed)) {
            return false;
        }
        CommonCellOrigin cellOrigin = commonFeed.getCellOrigin();
        if (!d(cellOrigin != null ? cellOrigin.getCellMedia() : null)) {
            return false;
        }
        CommonCellOrigin cellOrigin2 = commonFeed.getCellOrigin();
        return !w(cellOrigin2 != null ? cellOrigin2.getCellMedia() : null);
    }

    public static final boolean r(CommonFeed commonFeed) {
        if (commonFeed == null || !CommonFeedExtKt.isCommonForwardFeed(commonFeed)) {
            return false;
        }
        CommonCellOrigin cellOrigin = commonFeed.getCellOrigin();
        return w(cellOrigin != null ? cellOrigin.getCellMedia() : null);
    }

    public static final boolean s(CommonMedia commonMedia) {
        Integer type;
        return (commonMedia == null || (type = commonMedia.getType()) == null || type.intValue() != 0) ? false : true;
    }

    public static final boolean t(CommonFeed commonFeed) {
        CommonCellMedia cellMedia;
        return (commonFeed == null || (cellMedia = commonFeed.getCellMedia()) == null || !cellMedia.getLongPicsBrowsingMode()) ? false : true;
    }

    public static final boolean u(CommonFeed commonFeed) {
        CommonCellUserInfo cellUserInfo;
        CommonUser user;
        if (commonFeed == null || (cellUserInfo = commonFeed.getCellUserInfo()) == null || (user = cellUserInfo.getUser()) == null) {
            return false;
        }
        long uin = LoginData.getInstance().getUin();
        long k3 = ef.d.k(user.getUin());
        QLog.i("isMasterFeed", 1, "login uin is " + uin + ", feed uin is " + k3);
        return k3 == uin;
    }

    public static final boolean v(CommonFeed commonFeed) {
        return (commonFeed == null || !e(commonFeed) || x(commonFeed)) ? false : true;
    }

    public static final boolean w(CommonCellMedia commonCellMedia) {
        if (commonCellMedia == null || commonCellMedia.getMediaItems().size() != 1) {
            return false;
        }
        return z(commonCellMedia.getMediaItems().get(0));
    }

    public static final boolean x(CommonFeed commonFeed) {
        CommonCellMedia cellMedia;
        if (commonFeed == null || (cellMedia = commonFeed.getCellMedia()) == null || cellMedia.getMediaItems().size() != 1) {
            return false;
        }
        return z(cellMedia.getMediaItems().get(0));
    }

    public static final boolean y(CommonMedia commonMedia) {
        if (commonMedia != null) {
            return z(commonMedia) || s(commonMedia);
        }
        return false;
    }

    public static final boolean z(CommonMedia commonMedia) {
        Integer type;
        return (commonMedia == null || (type = commonMedia.getType()) == null || type.intValue() != 1) ? false : true;
    }

    public static final boolean n(CommonFeed commonFeed) {
        CommonCellCommon cellCommon;
        Long selfDeleteTime;
        Long l3 = null;
        if (commonFeed != null && (cellCommon = commonFeed.getCellCommon()) != null && (selfDeleteTime = cellCommon.getSelfDeleteTime()) != null) {
            if (selfDeleteTime.longValue() > 0) {
                l3 = selfDeleteTime;
            }
        }
        return l3 != null;
    }
}
