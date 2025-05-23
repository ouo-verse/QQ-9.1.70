package tencent.im.oidb.guild_search_recommend_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class guildSearchRecommendSvr$FirstShow extends MessageMicro<guildSearchRecommendSvr$FirstShow> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"banners", "recommend_tab"}, new Object[]{null, null}, guildSearchRecommendSvr$FirstShow.class);
    public final PBRepeatMessageField<guildSearchRecommendSvr$Banner> banners = PBField.initRepeatMessage(guildSearchRecommendSvr$Banner.class);
    public final PBRepeatMessageField<guildSearchRecommendSvr$RecommendTab> recommend_tab = PBField.initRepeatMessage(guildSearchRecommendSvr$RecommendTab.class);
}
