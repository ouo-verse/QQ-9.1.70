package tencent.im.troop.findtroop;

import com.tencent.mobileqq.pb.MessageMicro;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$RecommendGroup;
import tencent.im.troop.flock.QeventPB$Feed;

/* loaded from: classes29.dex */
public final class TabRecommendPB$RecommendGroup extends MessageMicro<TabRecommendPB$RecommendGroup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"recommend_group", "recommend_qevent"}, new Object[]{null, null}, TabRecommendPB$RecommendGroup.class);
    public guildSearchRecommendSvr$RecommendGroup recommend_group = new guildSearchRecommendSvr$RecommendGroup();
    public QeventPB$Feed recommend_qevent = new QeventPB$Feed();
}
