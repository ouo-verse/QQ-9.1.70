package rj1;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.j;
import com.tencent.mobileqq.guild.feed.util.GuildFeedCommentUtil;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0005\u001a\u00020\u0004J\"\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0005\u001a\u00020\u0004J$\u0010\u001a\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002J\"\u0010\u001c\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\n\u0010\u001b\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0005\u001a\u00020\u0004J*\u0010 \u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00132\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eJ\u001a\u0010!\u001a\u00020\n2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0004J\"\u0010%\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u00132\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006("}, d2 = {"Lrj1/a;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", "Lrj1/b;", "ext", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "b", "", PreloadTRTCPlayerParams.KEY_SIG, "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "c", "Landroid/content/Context;", "context", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "data", "", h.F, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "g", "T", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "section", "stFeed", "f", "mainData", "j", "image", "", com.tencent.luggage.wxa.c8.c.G, "i", "d", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "a", "view", "e", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f431544a = new a();

    a() {
    }

    private final GuildFeedDetailInitBean b(GProStFeed feed, b ext) {
        GuildFeedDetailInitBean initBean = GuildFeedDetailInitBean.initFeedDetailInitBeanFromFeed(feed);
        initBean.setIsMember(!ch.j0(initBean.getGuildId()));
        initBean.setBusinessType(ext.getBusinessType());
        a aVar = f431544a;
        String str = feed.channelInfo.sign.joinGuildSig;
        Intrinsics.checkNotNullExpressionValue(str, "feed.channelInfo.sign.joinGuildSig");
        initBean.setJoinInfoParam(aVar.c(str, ext));
        initBean.setStFeed(feed);
        Intrinsics.checkNotNullExpressionValue(initBean, "initBean");
        return initBean;
    }

    private final JumpGuildParam.JoinInfoParam c(String sig, b ext) {
        Pair<String, String> b16 = ext.b();
        return new JumpGuildParam.JoinInfoParam("", sig, b16.getFirst(), b16.getSecond());
    }

    @NotNull
    public final GuildFeedBaseInitBean a(@NotNull b ext) {
        Intrinsics.checkNotNullParameter(ext, "ext");
        GuildFeedBaseInitBean guildFeedBaseInitBean = new GuildFeedBaseInitBean();
        guildFeedBaseInitBean.setBusinessType(ext.getBusinessType());
        guildFeedBaseInitBean.setImmersiveSource(ext.a());
        return guildFeedBaseInitBean;
    }

    @NotNull
    public final JumpGuildParam.JoinInfoParam d(@NotNull qj1.h data, @NotNull b ext) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(ext, "ext");
        Object a16 = data.a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
        String joinGuildSig = ((GProStFeed) a16).channelInfo.sign.joinGuildSig;
        Intrinsics.checkNotNullExpressionValue(joinGuildSig, "joinGuildSig");
        return c(joinGuildSig, ext);
    }

    public final void e(@NotNull View view, @NotNull qj1.h data, @NotNull b ext) {
        GProStFeed gProStFeed;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(ext, "ext");
        Object a16 = data.a();
        if (a16 instanceof GProStFeed) {
            gProStFeed = (GProStFeed) a16;
        } else {
            gProStFeed = null;
        }
        if (gProStFeed == null) {
            return;
        }
        JumpGuildParam.JoinInfoParam c16 = c(gProStFeed.channelInfo.sign.joinGuildSig.toString(), ext);
        JumpGuildParam jumpGuildParam = new JumpGuildParam(String.valueOf(data.getGuildId()), null, c16.getJoinSignature(), c16.getMainSource(), c16.getSubSource());
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        GuildJumpUtil.n(context, jumpGuildParam);
    }

    public final <T> void f(@NotNull Section<T> section, @Nullable GProStFeed stFeed) {
        xj1.a aVar;
        Intrinsics.checkNotNullParameter(section, "section");
        if (stFeed != null && (aVar = (xj1.a) SectionIOCKt.getIocInterface(section, xj1.a.class)) != null) {
            aVar.a(stFeed);
        }
    }

    public final void g(@NotNull View rootView, @NotNull qj1.h data, @NotNull b ext) {
        GProStFeed gProStFeed;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(ext, "ext");
        Object a16 = data.a();
        if (a16 instanceof GProStFeed) {
            gProStFeed = (GProStFeed) a16;
        } else {
            gProStFeed = null;
        }
        GProStFeed gProStFeed2 = gProStFeed;
        if (gProStFeed2 == null) {
            return;
        }
        GuildFeedCommentUtil.o(GuildFeedCommentUtil.f223766a, rootView, gProStFeed2, b(gProStFeed2, ext), null, 8, null);
    }

    public final void h(@NotNull Context context, @NotNull qj1.h data, @NotNull b ext) {
        GProStFeed gProStFeed;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(ext, "ext");
        Object a16 = data.a();
        if (a16 instanceof GProStFeed) {
            gProStFeed = (GProStFeed) a16;
        } else {
            gProStFeed = null;
        }
        if (gProStFeed == null) {
            return;
        }
        GuildFeedDetailInitBean b16 = b(gProStFeed, ext);
        b16.setImmersiveSource(ext.a());
        GuildFeedLauncher.x(context, b16, Boolean.valueOf(((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).needOpenNativeDetailPage(gProStFeed)));
    }

    public final void i(@NotNull View image, @NotNull qj1.h data, @NotNull b ext, int pos) {
        GProStFeed gProStFeed;
        ImageView imageView;
        Object orNull;
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(ext, "ext");
        Object a16 = data.a();
        GProStImage gProStImage = null;
        if (a16 instanceof GProStFeed) {
            gProStFeed = (GProStFeed) a16;
        } else {
            gProStFeed = null;
        }
        if (gProStFeed == null) {
            return;
        }
        if (image instanceof ImageView) {
            imageView = (ImageView) image;
        } else {
            imageView = null;
        }
        if (imageView != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(com.tencent.mobileqq.guild.feed.gallery.b.d(gProStFeed), pos);
            GuildFeedRichMediaData guildFeedRichMediaData = (GuildFeedRichMediaData) orNull;
            if (guildFeedRichMediaData != null) {
                int type = guildFeedRichMediaData.getType();
                if (type != 0) {
                    if (type == 1) {
                        gProStImage = guildFeedRichMediaData.getVideo().cover;
                    }
                } else {
                    gProStImage = guildFeedRichMediaData.getImage();
                }
                GProStImage gProStImage2 = gProStImage;
                if (gProStImage2 != null) {
                    j.f221614a.b(imageView, gProStFeed, gProStImage2, ext.getBusinessType(), ext.e());
                }
            }
        }
    }

    public final void j(@NotNull Context context, @NotNull qj1.h mainData, @NotNull b ext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mainData, "mainData");
        Intrinsics.checkNotNullParameter(ext, "ext");
        Object a16 = mainData.a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
        ax.I((Activity) context, String.valueOf(mainData.getGuildId()), String.valueOf(mainData.getChannelId()), mainData.r(), mainData.getFeedId(), 20, c(String.valueOf(((GProStFeed) a16).channelInfo.sign.channelId), ext));
    }
}
