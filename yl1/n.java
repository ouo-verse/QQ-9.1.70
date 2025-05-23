package yl1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import androidx.annotation.StringRes;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.IocPromise;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.CommentFunctionPart;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0005\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u0005\u001a\n\u0010\t\u001a\u00020\u0006*\u00020\u0005\u001a\n\u0010\u000b\u001a\u00020\u0006*\u00020\n\u001a\n\u0010\r\u001a\u00020\f*\u00020\n\u001a\n\u0010\u000f\u001a\u00020\u000e*\u00020\n\u001a\n\u0010\u0010\u001a\u00020\f*\u00020\n\u001a\u0012\u0010\u0013\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012*\u00020\u0005\u001a\f\u0010\u0016\u001a\u0004\u0018\u00010\u0015*\u00020\u0014\u001a\u001a\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u000e\u001a\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\f2\b\b\u0001\u0010\u001b\u001a\u00020\u000e\u001a\u0016\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001d\u001a\u0018\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u000e2\b\b\u0001\u0010\u001b\u001a\u00020\u000e\u001a\u0016\u0010\"\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001d\u001a(\u0010(\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020$2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030&\u001a\u001c\u0010-\u001a\u00020)*\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u00152\u0006\u0010,\u001a\u00020+\u001a\u000e\u00101\u001a\u0002002\u0006\u0010/\u001a\u00020.\u001a'\u00105\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u00102*\u00020\u00002\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000003\u00a2\u0006\u0004\b5\u00106\u001a&\u0010:\u001a\u00020\u0003\"\u0004\b\u0000\u00102*\u00020\u00002\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u0000032\u0006\u00109\u001a\u000208\u001a\u001e\u0010;\u001a\u00020\u0003\"\u0004\b\u0000\u00102*\u00020\u00002\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u000003\u001a\u000e\u0010=\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u000e\u001a$\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000>\"\u0004\b\u0000\u00102*\u00020\u00002\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000003\u001a\f\u0010A\u001a\u0004\u0018\u00010@*\u00020.\u00a8\u0006B"}, d2 = {"Landroid/view/View;", "", "expendSize", "", "f", "Lcom/tencent/biz/richframework/part/Part;", "", "o", "r", "l", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "w", "", "k", "u", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "p", "Ltl1/g$l;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "j", "needPostToast", "toastResId", "c", "isSuccess", "msgResId", "B", "", "msg", BdhLogUtil.LogTag.Tag_Conn, "icon", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "tag", "", "timeThreshold", "Lkotlin/Function0;", "block", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$h;", "mainData", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "partHost", HippyTKDListViewAdapter.X, "Landroid/os/Bundle;", "arguments", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart$a$a;", DomainData.DOMAIN_NAME, "T", "Ljava/lang/Class;", "clazz", ReportConstant.COSTREPORT_PREFIX, "(Landroid/view/View;Ljava/lang/Class;)Ljava/lang/Object;", "iocClass", "", "ioc", "y", "D", "result", "v", "Lcom/tencent/biz/richframework/ioc/callback/IocPromise;", "t", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class n {
    public static final void A(int i3, @NotNull CharSequence msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            QQToast.makeText(context, i3, msg2, 0).show();
        }
    }

    public static final void B(boolean z16, @StringRes int i3) {
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            String string = context.getString(i3);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(msgResId)");
            C(z16, string);
        }
    }

    public static final void C(boolean z16, @NotNull CharSequence msg2) {
        int i3;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            if (z16) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            QQToast.makeText(context, i3, msg2, 0).show();
        }
    }

    public static final <T> void D(@NotNull View view, @NotNull Class<T> iocClass) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(iocClass, "iocClass");
        RFWIocAbilityProvider.g().unregisterSingleIoc(view, iocClass);
    }

    public static final boolean c(boolean z16, final int i3) {
        if (!NetworkUtil.isNetworkAvailable()) {
            if (z16) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: yl1.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.e(i3);
                    }
                });
                return true;
            }
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean d(boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = true;
        }
        if ((i16 & 2) != 0) {
            i3 = R.string.f144630pa;
        }
        return c(z16, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(int i3) {
        QQToast.makeText(BaseApplication.getContext(), 1, i3, 0).show();
    }

    public static final void f(@NotNull final View view, final float f16) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        final View view2 = (View) parent;
        view2.post(new Runnable() { // from class: yl1.l
            @Override // java.lang.Runnable
            public final void run() {
                n.g(view, f16, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(View this_expandTouchZone, float f16, View parentView) {
        Intrinsics.checkNotNullParameter(this_expandTouchZone, "$this_expandTouchZone");
        Intrinsics.checkNotNullParameter(parentView, "$parentView");
        Rect rect = new Rect();
        this_expandTouchZone.getHitRect(rect);
        rect.left -= com.tencent.mobileqq.guild.feed.util.e.a(this_expandTouchZone.getContext(), f16);
        rect.top -= com.tencent.mobileqq.guild.feed.util.e.a(this_expandTouchZone.getContext(), f16);
        rect.right += com.tencent.mobileqq.guild.feed.util.e.a(this_expandTouchZone.getContext(), f16);
        rect.bottom += com.tencent.mobileqq.guild.feed.util.e.a(this_expandTouchZone.getContext(), f16);
        parentView.setTouchDelegate(new TouchDelegate(rect, this_expandTouchZone));
    }

    public static final void h(@NotNull String tag, long j3, @NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(block, "block");
        if (com.tencent.mobileqq.guild.util.o.d(tag, j3)) {
            QLog.i(tag, 4, "isFastCall");
        } else {
            block.invoke();
        }
    }

    public static /* synthetic */ void i(String str, long j3, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        if ((i3 & 2) != 0) {
            j3 = 500;
        }
        h(str, j3, function0);
    }

    @Nullable
    public static final FeedDetailMainData j(@NotNull g.OnDataListChangedMessage onDataListChangedMessage) {
        Intrinsics.checkNotNullParameter(onDataListChangedMessage, "<this>");
        for (hl1.g gVar : onDataListChangedMessage.b()) {
            if (gVar.getItemType() == 1 || gVar.getItemType() == 12) {
                if (gVar instanceof FeedDetailMainData) {
                    return (FeedDetailMainData) gVar;
                }
            }
        }
        return null;
    }

    public static final int k(@NotNull com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.c cVar) {
        boolean z16;
        Bundle b16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intent a16 = com.tencent.mobileqq.guild.feed.part.a.a(cVar);
        boolean z17 = true;
        if (a16 != null && a16.hasExtra("business_type")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Intent a17 = com.tencent.mobileqq.guild.feed.part.a.a(cVar);
            if (a17 == null) {
                return 0;
            }
            return a17.getIntExtra("business_type", 0);
        }
        Bundle b17 = com.tencent.mobileqq.guild.feed.part.a.b(cVar);
        if (b17 == null || !b17.containsKey("business_type")) {
            z17 = false;
        }
        if (!z17 || (b16 = com.tencent.mobileqq.guild.feed.part.a.b(cVar)) == null) {
            return 0;
        }
        return b16.getInt("business_type");
    }

    @NotNull
    public static final String l(@NotNull Part part) {
        String str;
        Activity hostActivity;
        Intent intent;
        Bundle extras;
        Intrinsics.checkNotNullParameter(part, "<this>");
        IPartHost partHost = part.getPartHost();
        String str2 = null;
        String str3 = "";
        if (partHost != null && (hostActivity = partHost.getHostActivity()) != null && (intent = hostActivity.getIntent()) != null && (extras = intent.getExtras()) != null) {
            str = extras.getString("channel_id", "");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            Bundle arguments = part.getHostFragment().getArguments();
            if (arguments != null) {
                str2 = arguments.getString("channel_id");
            }
            if (str2 != null) {
                str3 = str2;
            }
            return str3;
        }
        return str;
    }

    @NotNull
    public static final String m(@NotNull com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.c cVar) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intent a16 = com.tencent.mobileqq.guild.feed.part.a.a(cVar);
        String str3 = "";
        if (a16 == null || (str = a16.getStringExtra("guild_feed_channel_name")) == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            Bundle b16 = com.tencent.mobileqq.guild.feed.part.a.b(cVar);
            if (b16 != null) {
                str2 = b16.getString("guild_feed_channel_name");
            } else {
                str2 = null;
            }
            if (str2 != null) {
                str3 = str2;
            }
            return str3;
        }
        return str;
    }

    @NotNull
    public static final CommentFunctionPart.Companion.CommentInitArgs n(@NotNull Bundle arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        String string = arguments.getString("feed_id", "");
        String string2 = arguments.getString("guild_id", "");
        String string3 = arguments.getString("channel_id", "");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(NativeDetailConstants.GUILD_ID, \"\")");
        Intrinsics.checkNotNullExpressionValue(string3, "getString(NativeDetailConstants.CHANNEL_ID, \"\")");
        Intrinsics.checkNotNullExpressionValue(string, "getString(NativeDetailConstants.FEED_ID, \"\")");
        return new CommentFunctionPart.Companion.CommentInitArgs(string2, string3, string, null, false, 24, null);
    }

    @NotNull
    public static final String o(@NotNull Part part) {
        String str;
        Intrinsics.checkNotNullParameter(part, "<this>");
        Bundle h16 = GuildSplitViewUtils.f235370a.h(part.getPartHost());
        String str2 = null;
        String str3 = "";
        if (h16 != null) {
            str = h16.getString("feed_id", "");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            Bundle arguments = part.getHostFragment().getArguments();
            if (arguments != null) {
                str2 = arguments.getString("feed_id");
            }
            if (str2 != null) {
                str3 = str2;
            }
            return str3;
        }
        return str;
    }

    @Nullable
    public static final qj1.h p(@NotNull Part part) {
        g.OnGetFeedDetailMainDataMessage onGetFeedDetailMainDataMessage;
        FeedDetailMainData feedDetailMainData;
        Intrinsics.checkNotNullParameter(part, "<this>");
        Object broadcastGetMessage = part.broadcastGetMessage("action_get_detail_main_data", null);
        if (broadcastGetMessage instanceof g.OnGetFeedDetailMainDataMessage) {
            onGetFeedDetailMainDataMessage = (g.OnGetFeedDetailMainDataMessage) broadcastGetMessage;
        } else {
            onGetFeedDetailMainDataMessage = null;
        }
        if (onGetFeedDetailMainDataMessage == null || (feedDetailMainData = onGetFeedDetailMainDataMessage.getFeedDetailMainData()) == null) {
            return null;
        }
        return feedDetailMainData.getFeedDetail();
    }

    @Nullable
    public static final GuildFeedPublishInfo q(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Serializable serializable = bundle.getSerializable("guild_feed_publish_info");
        if (serializable instanceof GuildFeedPublishInfo) {
            return (GuildFeedPublishInfo) serializable;
        }
        return null;
    }

    @NotNull
    public static final String r(@NotNull Part part) {
        String str;
        Intrinsics.checkNotNullParameter(part, "<this>");
        Bundle h16 = GuildSplitViewUtils.f235370a.h(part.getPartHost());
        String str2 = null;
        String str3 = "";
        if (h16 != null) {
            str = h16.getString("guild_id", "");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            Bundle arguments = part.getHostFragment().getArguments();
            if (arguments != null) {
                str2 = arguments.getString("guild_id");
            }
            if (str2 != null) {
                str3 = str2;
            }
            return str3;
        }
        return str;
    }

    @Nullable
    public static final <T> T s(@NotNull View view, @NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) RFWIocAbilityProvider.g().getIocInterface(clazz, view, null);
    }

    @NotNull
    public static final <T> IocPromise<T> t(@NotNull View view, @NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        IocPromise<T> originView = RFWIocAbilityProvider.g().getIoc(clazz).originView(view);
        Intrinsics.checkNotNullExpressionValue(originView, "g().getIoc(clazz).originView(this)");
        return originView;
    }

    public static final boolean u(@NotNull com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.c cVar) {
        boolean z16;
        AppInterface appInterface;
        IGProGuildInfo guildInfo;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intent a16 = com.tencent.mobileqq.guild.feed.part.a.a(cVar);
        boolean z17 = true;
        if (a16 != null && a16.hasExtra("guild_feed_is_member")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Intent a17 = com.tencent.mobileqq.guild.feed.part.a.a(cVar);
            if (a17 == null) {
                return false;
            }
            return a17.getBooleanExtra("guild_feed_is_member", false);
        }
        Bundle b16 = com.tencent.mobileqq.guild.feed.part.a.b(cVar);
        if (b16 == null || !b16.containsKey("guild_feed_is_member")) {
            z17 = false;
        }
        if (z17) {
            Bundle b17 = com.tencent.mobileqq.guild.feed.part.a.b(cVar);
            if (b17 == null) {
                return false;
            }
            return b17.getBoolean("guild_feed_is_member");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService == null || (guildInfo = iGPSService.getGuildInfo(r(cVar))) == null) {
            return false;
        }
        return guildInfo.isMember();
    }

    public static final boolean v(int i3) {
        if (i3 != 1013 && i3 != -93 && i3 != 1002) {
            return false;
        }
        return true;
    }

    public static final boolean w(@NotNull com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.c cVar) {
        boolean z16;
        Bundle b16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intent a16 = com.tencent.mobileqq.guild.feed.part.a.a(cVar);
        boolean z17 = false;
        if (a16 != null && a16.hasExtra("guild_feed_support_at_entrance")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Intent a17 = com.tencent.mobileqq.guild.feed.part.a.a(cVar);
            if (a17 == null) {
                return true;
            }
            return a17.getBooleanExtra("guild_feed_support_at_entrance", true);
        }
        Bundle b17 = com.tencent.mobileqq.guild.feed.part.a.b(cVar);
        if (b17 != null && b17.containsKey("guild_feed_support_at_entrance")) {
            z17 = true;
        }
        if (!z17 || (b16 = com.tencent.mobileqq.guild.feed.part.a.b(cVar)) == null) {
            return true;
        }
        return b16.getBoolean("guild_feed_support_at_entrance");
    }

    @NotNull
    public static final a.OnCommentMainFeedDataResult x(@NotNull a.OnCommentMainFeedDataResult onCommentMainFeedDataResult, @Nullable FeedDetailMainData feedDetailMainData, @NotNull IPartHost partHost) {
        String str;
        String str2;
        String str3;
        qj1.h feedDetail;
        Intrinsics.checkNotNullParameter(onCommentMainFeedDataResult, "<this>");
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        if (feedDetailMainData != null && (feedDetail = feedDetailMainData.getFeedDetail()) != null) {
            onCommentMainFeedDataResult.b(new a.CommentMainFeedData(String.valueOf(feedDetail.getGuildId()), String.valueOf(feedDetail.getChannelId()), feedDetail.getFeedId(), feedDetail.getCreateTime(), feedDetail.r()));
            return onCommentMainFeedDataResult;
        }
        Bundle h16 = GuildSplitViewUtils.f235370a.h(partHost);
        String str4 = null;
        if (h16 != null) {
            str = h16.getString("guild_id", "");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "extras?.getString(Native\u2026tants.GUILD_ID, \"\") ?: \"\"");
        }
        if (h16 != null) {
            str2 = h16.getString("channel_id", "");
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str2, "extras?.getString(Native\u2026nts.CHANNEL_ID, \"\") ?: \"\"");
        }
        if (h16 != null) {
            str4 = h16.getString("feed_id", "");
        }
        if (str4 == null) {
            str3 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str4, "extras?.getString(Native\u2026stants.FEED_ID, \"\") ?: \"\"");
            str3 = str4;
        }
        onCommentMainFeedDataResult.b(new a.CommentMainFeedData(str, str2, str3, 0L, null, 24, null));
        return onCommentMainFeedDataResult;
    }

    public static final <T> void y(@NotNull View view, @NotNull Class<T> iocClass, @NotNull Object ioc) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(iocClass, "iocClass");
        Intrinsics.checkNotNullParameter(ioc, "ioc");
        RFWIocAbilityProvider.g().registerIoc(view, ioc, iocClass);
    }

    public static final void z(int i3, @StringRes int i16) {
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            QQToast.makeText(context, i3, i16, 0).show();
        }
    }
}
