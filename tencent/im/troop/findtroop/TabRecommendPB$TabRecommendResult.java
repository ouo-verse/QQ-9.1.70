package tencent.im.troop.findtroop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$RecommendGroup;
import tencent.im.oidb.oidb_0xc26$MayKnowPerson;
import tencent.im.oidb.oidb_0xc26$QzoneInfo;
import tencent.im.troop.flock.QeventPB$Feed;

/* loaded from: classes29.dex */
public final class TabRecommendPB$TabRecommendResult extends MessageMicro<TabRecommendPB$TabRecommendResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66}, new String[]{"type", "type_title", "recommend_groups", "recommend_qevents", "recommend_guilds", "recommend_person", "new_recommend_groups", "qzone_info"}, new Object[]{0, "", null, null, null, null, null, null}, TabRecommendPB$TabRecommendResult.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField type_title = PBField.initString("");
    public final PBRepeatMessageField<guildSearchRecommendSvr$RecommendGroup> recommend_groups = PBField.initRepeatMessage(guildSearchRecommendSvr$RecommendGroup.class);
    public final PBRepeatMessageField<QeventPB$Feed> recommend_qevents = PBField.initRepeatMessage(QeventPB$Feed.class);
    public final PBRepeatMessageField<guildSearchRecommendSvr$RecommendGroup> recommend_guilds = PBField.initRepeatMessage(guildSearchRecommendSvr$RecommendGroup.class);
    public final PBRepeatMessageField<oidb_0xc26$MayKnowPerson> recommend_person = PBField.initRepeatMessage(oidb_0xc26$MayKnowPerson.class);
    public final PBRepeatMessageField<TabRecommendPB$RecommendGroup> new_recommend_groups = PBField.initRepeatMessage(TabRecommendPB$RecommendGroup.class);
    public oidb_0xc26$QzoneInfo qzone_info = new oidb_0xc26$QzoneInfo();
}
