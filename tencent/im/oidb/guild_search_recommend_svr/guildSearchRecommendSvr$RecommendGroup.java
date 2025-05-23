package tencent.im.oidb.guild_search_recommend_svr;

import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import tencent.im.oidb.cmd0xf57.cmd0xf57$MedalInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class guildSearchRecommendSvr$RecommendGroup extends MessageMicro<guildSearchRecommendSvr$RecommendGroup> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field activity;
    public final PBBytesField bytes_algorithm;
    public final PBUInt32Field group_flag;
    public final PBUInt32Field group_flag_ext;
    public final PBStringField icon;
    public final PBBytesField join_group_auth;
    public final PBRepeatMessageField<cmd0xf57$MedalInfo> medals;
    public final PBUInt32Field member_max_num;
    public final PBUInt32Field member_num;
    public final PBBytesField memo;
    public final PBBytesField name;
    public final PBUInt64Field owner_uin;
    public final PBStringField recom_trace;
    public final PBEnumField source;
    public final PBRepeatMessageField<guildSearchRecommendSvr$Label> states;
    public guildSearchRecommendSvr$Label tag_wording;
    public final PBRepeatMessageField<guildSearchRecommendSvr$Label> tags;
    public final PBInt32Field uin_privilege;
    public final PBRepeatMessageField<guildSearchRecommendSvr$Label> v2_tags;
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field code = PBField.initUInt64(0);

    static {
        String[] strArr = {"type", "code", "name", "icon", "memo", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "states", PhotoCacheData.OWNER_UIN, "member_num", "member_max_num", "group_flag_ext", "group_flag", "source", "join_group_auth", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "uin_privilege", "tag_wording", "bytes_algorithm", "v2_tags", "medals", "recom_trace"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 64, 72, 80, 88, 96, 104, 114, 120, 128, 138, 146, 154, 162, 170}, strArr, new Object[]{0, 0L, byteStringMicro, "", byteStringMicro, null, null, 0L, 0, 0, 0, 0, 0, byteStringMicro, 0, 0, null, byteStringMicro, null, null, ""}, guildSearchRecommendSvr$RecommendGroup.class);
    }

    public guildSearchRecommendSvr$RecommendGroup() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.name = PBField.initBytes(byteStringMicro);
        this.icon = PBField.initString("");
        this.memo = PBField.initBytes(byteStringMicro);
        this.tags = PBField.initRepeatMessage(guildSearchRecommendSvr$Label.class);
        this.states = PBField.initRepeatMessage(guildSearchRecommendSvr$Label.class);
        this.owner_uin = PBField.initUInt64(0L);
        this.member_num = PBField.initUInt32(0);
        this.member_max_num = PBField.initUInt32(0);
        this.group_flag_ext = PBField.initUInt32(0);
        this.group_flag = PBField.initUInt32(0);
        this.source = PBField.initEnum(0);
        this.join_group_auth = PBField.initBytes(byteStringMicro);
        this.activity = PBField.initUInt32(0);
        this.uin_privilege = PBField.initInt32(0);
        this.tag_wording = new guildSearchRecommendSvr$Label();
        this.bytes_algorithm = PBField.initBytes(byteStringMicro);
        this.v2_tags = PBField.initRepeatMessage(guildSearchRecommendSvr$Label.class);
        this.medals = PBField.initRepeatMessage(cmd0xf57$MedalInfo.class);
        this.recom_trace = PBField.initString("");
    }
}
