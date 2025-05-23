package xn1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.core.os.BundleKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.feedsquare.data.g;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.j;
import com.tencent.mobileqq.guild.feed.nativepublish.FeedEditorConfiguration;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.topic.PageData;
import com.tencent.mobileqq.guild.feed.util.GuildFeedCommentUtil;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextTopicContent;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vn1.TopicDataExt;
import vn1.f;
import vn1.i;
import vn1.k;
import vn1.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bJ\u0010KJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0002J6\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0019\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017J\u0016\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0017J$\u0010!\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0005J\u001a\u0010%\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f2\n\u0010$\u001a\u00060\"j\u0002`#J(\u0010+\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)J\u000e\u0010-\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0017J0\u00104\u001a\u00020\u00172\n\u0010.\u001a\u00060\"j\u0002`#2\u0006\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u00020\u000e2\n\b\u0002\u00103\u001a\u0004\u0018\u000102J\n\u00105\u001a\u00020\u0017*\u00020\u0017J\u0014\u00106\u001a\u00020\u0017*\u00020\u00172\b\u00103\u001a\u0004\u0018\u000102J\u0010\u00108\u001a\u0004\u0018\u0001072\u0006\u0010,\u001a\u00020\u0017J\u0016\u0010;\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u0017J\u001c\u0010?\u001a\u00020\u00112\f\u0010>\u001a\b\u0012\u0004\u0012\u00020=0<2\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010A\u001a\u00020'2\u0006\u0010@\u001a\u00020'R\u0017\u0010E\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010B\u001a\u0004\bC\u0010DR\u0018\u0010I\u001a\u00020'*\u00020F8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bG\u0010H\u00a8\u0006L"}, d2 = {"Lxn1/e;", "", "", "topicGuildId", "b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "e", PreloadTRTCPlayerParams.KEY_SIG, "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "f", "Landroid/content/Context;", "context", "", "topicId", "topicName", "", "hasDraft", "", "hintText", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lvn1/b;", "topicFeedData", "k", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "j", "T", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "section", "stFeed", "i", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "mainData", DomainData.DOMAIN_NAME, "image", "", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishInfo;", "feedPublishInfo", "l", "data", "g", "displayable", "Lvn1/d;", "ext", "seq", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", "taskProgressState", "o", "r", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "a", "it", "mData", h.F, "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "topicContents", "d", "type", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "I", "getTOPIC_PUBLISH_REQ_ID", "()I", "TOPIC_PUBLISH_REQ_ID", "Lcom/tencent/mobileqq/guild/feed/topic/PageData;", "c", "(Lcom/tencent/mobileqq/guild/feed/topic/PageData;)I", "immersiveSource", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f448187a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int TOPIC_PUBLISH_REQ_ID = RandomKt.Random(0).nextInt();

    e() {
    }

    private final String b(String topicGuildId) {
        Object obj;
        List<IGProChannelInfo> specificTypeChannelList = ((IGPSService) ch.R0(IGPSService.class)).getSpecificTypeChannelList(topicGuildId, 7);
        Intrinsics.checkNotNullExpressionValue(specificTypeChannelList, "runtimeService(IGPSServi\u2026elType.CHANNEL_TYPE_FEED)");
        Iterator<T> it = specificTypeChannelList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((IGProChannelInfo) obj).isHiddenPostChannel()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        IGProChannelInfo iGProChannelInfo = (IGProChannelInfo) obj;
        if (iGProChannelInfo == null) {
            return null;
        }
        return iGProChannelInfo.getChannelUin();
    }

    private final int c(PageData pageData) {
        PageData.Companion companion = PageData.INSTANCE;
        if (Intrinsics.areEqual(pageData, companion.a()) || !Intrinsics.areEqual(pageData, companion.b())) {
            return 21;
        }
        return 20;
    }

    private final GuildFeedDetailInitBean e(GProStFeed feed) {
        GuildFeedDetailInitBean initBean = GuildFeedDetailInitBean.initFeedDetailInitBeanFromFeed(feed);
        initBean.setIsMember(!ch.j0(initBean.getGuildId()));
        initBean.setBusinessType(20);
        e eVar = f448187a;
        String str = feed.channelInfo.sign.joinGuildSig;
        Intrinsics.checkNotNullExpressionValue(str, "feed.channelInfo.sign.joinGuildSig");
        initBean.setJoinInfoParam(eVar.f(str));
        initBean.setStFeed(feed);
        Intrinsics.checkNotNullExpressionValue(initBean, "initBean");
        return initBean;
    }

    private final JumpGuildParam.JoinInfoParam f(String sig) {
        return new JumpGuildParam.JoinInfoParam("", sig, "discover_new", "topic_page");
    }

    public static /* synthetic */ vn1.b p(e eVar, qj1.h hVar, TopicDataExt topicDataExt, long j3, GuildTaskProgressState guildTaskProgressState, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            j3 = 0;
        }
        long j16 = j3;
        if ((i3 & 8) != 0) {
            guildTaskProgressState = null;
        }
        return eVar.o(hVar, topicDataExt, j16, guildTaskProgressState);
    }

    @Nullable
    public final GuildFeedBaseInitBean a(@NotNull vn1.b data) {
        Intrinsics.checkNotNullParameter(data, "data");
        GuildFeedBaseInitBean guildFeedBaseInitBean = new GuildFeedBaseInitBean();
        guildFeedBaseInitBean.setBusinessType(20);
        guildFeedBaseInitBean.setImmersiveSource(f448187a.c(data.getExt().getPageData()));
        guildFeedBaseInitBean.setTopicId(data.getExt().getTopicId());
        return guildFeedBaseInitBean;
    }

    public final boolean d(@NotNull List<GProStRichTextContent> topicContents, @NotNull String topicName) {
        CharSequence trim;
        String removePrefix;
        String str;
        String topicName2;
        Intrinsics.checkNotNullParameter(topicContents, "topicContents");
        Intrinsics.checkNotNullParameter(topicName, "topicName");
        trim = StringsKt__StringsKt.trim((CharSequence) topicName);
        removePrefix = StringsKt__StringsKt.removePrefix(trim.toString(), (CharSequence) "#");
        Iterator<GProStRichTextContent> it = topicContents.iterator();
        while (it.hasNext()) {
            GProStRichTextTopicContent topicContent = it.next().getTopicContent();
            if (topicContent != null && (topicName2 = topicContent.getTopicName()) != null) {
                str = StringsKt__StringsKt.removePrefix(topicName2, (CharSequence) "#");
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, removePrefix)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final JumpGuildParam.JoinInfoParam g(@NotNull vn1.b data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Object a16 = data.d().a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
        String joinGuildSig = ((GProStFeed) a16).channelInfo.sign.joinGuildSig;
        Intrinsics.checkNotNullExpressionValue(joinGuildSig, "joinGuildSig");
        return f(joinGuildSig);
    }

    public final void h(@NotNull View it, @NotNull vn1.b mData) {
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(mData, "mData");
        Object a16 = mData.d().a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
        JumpGuildParam.JoinInfoParam f16 = f(((GProStFeed) a16).channelInfo.sign.joinGuildSig.toString());
        JumpGuildParam jumpGuildParam = new JumpGuildParam(String.valueOf(mData.d().getGuildId()), null, f16.getJoinSignature(), f16.getMainSource(), f16.getSubSource());
        Context context = it.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        GuildJumpUtil.n(context, jumpGuildParam);
    }

    public final <T> void i(@NotNull Section<T> section, @Nullable GProStFeed stFeed) {
        xj1.a aVar;
        Intrinsics.checkNotNullParameter(section, "section");
        if (stFeed != null && (aVar = (xj1.a) SectionIOCKt.getIocInterface(section, xj1.a.class)) != null) {
            aVar.a(stFeed);
        }
    }

    public final void j(@NotNull View rootView, @NotNull vn1.b topicFeedData) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(topicFeedData, "topicFeedData");
        Object a16 = topicFeedData.d().a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
        GProStFeed gProStFeed = (GProStFeed) a16;
        GuildFeedCommentUtil.o(GuildFeedCommentUtil.f223766a, rootView, gProStFeed, e(gProStFeed), null, 8, null);
    }

    public final void k(@NotNull Context context, @NotNull vn1.b topicFeedData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(topicFeedData, "topicFeedData");
        Object a16 = topicFeedData.d().a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
        GProStFeed gProStFeed = (GProStFeed) a16;
        GuildFeedDetailInitBean e16 = e(gProStFeed);
        e16.setImmersiveSource(f448187a.c(topicFeedData.getExt().getPageData()));
        GuildTaskProgressState taskProgressState = topicFeedData.getTaskProgressState();
        if (taskProgressState != null) {
            e16.setGuildFeedPublishInfo(g.a(taskProgressState, topicFeedData.d().w()));
        }
        e16.setTopicId(topicFeedData.getExt().getTopicId());
        GuildFeedLauncher.x(context, e16, Boolean.valueOf(((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).needOpenNativeDetailPage(gProStFeed)));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(@NotNull View image, @NotNull vn1.b topicFeedData, int pos, @Nullable GuildFeedPublishInfo feedPublishInfo) {
        ImageView imageView;
        Object orNull;
        GProStImage image2;
        GProStImage gProStImage;
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(topicFeedData, "topicFeedData");
        Object a16 = topicFeedData.d().a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
        GProStFeed gProStFeed = (GProStFeed) a16;
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
                    if (type != 1) {
                        gProStImage = null;
                        if (gProStImage == null) {
                            j.f221614a.b(imageView, gProStFeed, gProStImage, 20, feedPublishInfo);
                            return;
                        }
                        return;
                    }
                    image2 = guildFeedRichMediaData.getVideo().cover;
                } else {
                    image2 = guildFeedRichMediaData.getImage();
                }
                gProStImage = image2;
                if (gProStImage == null) {
                }
            }
        }
    }

    public final void m(@NotNull Context context, long topicId, @NotNull String topicName, @NotNull String topicGuildId, boolean hasDraft, @NotNull CharSequence hintText) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(topicName, "topicName");
        Intrinsics.checkNotNullParameter(topicGuildId, "topicGuildId");
        Intrinsics.checkNotNullParameter(hintText, "hintText");
        String b16 = b(topicGuildId);
        QLog.d("GuildTopic.TopicMisc", 1, " channelId= " + b16 + " ,guildId = " + topicGuildId);
        GuildFeedBaseInitBean guildFeedBaseInitBean = new GuildFeedBaseInitBean();
        guildFeedBaseInitBean.setBusinessType(20);
        guildFeedBaseInitBean.setGuildId(topicGuildId);
        guildFeedBaseInitBean.setChannelId(b16);
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to(com.tencent.mobileqq.guild.feed.b.f218115a, guildFeedBaseInitBean), TuplesKt.to("launch_request_id", Integer.valueOf(TOPIC_PUBLISH_REQ_ID)), TuplesKt.to("launch_draft_key", String.valueOf(topicId)), TuplesKt.to("launch_hint_text", hintText));
        bundleOf.putParcelable("launch_config", new FeedEditorConfiguration(false, false, false, false, false, false, false, false, 127, null));
        bundleOf.putBundle("topic_element_append", BundleKt.bundleOf(TuplesKt.to("topic_id", Long.valueOf(topicId)), TuplesKt.to("topic_name", topicName), TuplesKt.to("topic_auto_insert", Boolean.valueOf(!hasDraft))));
        em1.a.f396585a.i(context, 1, bundleOf);
    }

    public final void n(@NotNull Context context, @NotNull qj1.h mainData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mainData, "mainData");
        Object a16 = mainData.a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
        ax.I((Activity) context, String.valueOf(mainData.getGuildId()), String.valueOf(mainData.getChannelId()), mainData.r(), mainData.getFeedId(), 20, f(String.valueOf(((GProStFeed) a16).channelInfo.sign.channelId)));
    }

    @NotNull
    public final vn1.b o(@NotNull qj1.h displayable, @NotNull TopicDataExt ext, long seq, @Nullable GuildTaskProgressState taskProgressState) {
        Intrinsics.checkNotNullParameter(displayable, "displayable");
        Intrinsics.checkNotNullParameter(ext, "ext");
        int o16 = displayable.o();
        if (o16 != 2) {
            if (o16 != 3) {
                if (o16 != 5) {
                    if (o16 != 7) {
                        if (o16 != 8) {
                            if (o16 != 9) {
                                return new f(displayable, ext, seq, taskProgressState);
                            }
                            return new i(displayable, ext, seq, taskProgressState);
                        }
                        return new k(displayable, ext, seq, taskProgressState);
                    }
                    return new vn1.j(displayable, ext, seq, taskProgressState);
                }
                return new l(displayable, ext, seq, taskProgressState);
            }
            return new vn1.h(displayable, ext, seq, taskProgressState);
        }
        return new vn1.g(displayable, ext, seq, taskProgressState);
    }

    public final int q(int type) {
        PageData.Companion companion = PageData.INSTANCE;
        if (type == companion.a().getType()) {
            return 3;
        }
        if (type == companion.b().getType()) {
            return 1;
        }
        return 0;
    }

    @NotNull
    public final vn1.b r(@NotNull vn1.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        return o(bVar.d(), bVar.getExt(), 1 + bVar.getSeq(), bVar.getTaskProgressState());
    }

    @NotNull
    public final vn1.b s(@NotNull vn1.b bVar, @Nullable GuildTaskProgressState guildTaskProgressState) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        return o(bVar.d(), bVar.getExt(), 1 + bVar.getSeq(), guildTaskProgressState);
    }
}
