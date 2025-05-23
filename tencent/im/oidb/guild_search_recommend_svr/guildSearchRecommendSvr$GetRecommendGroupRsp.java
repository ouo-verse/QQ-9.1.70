package tencent.im.oidb.guild_search_recommend_svr;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class guildSearchRecommendSvr$GetRecommendGroupRsp extends MessageMicro<guildSearchRecommendSvr$GetRecommendGroupRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42}, new String[]{"recommend_groups", "is_end", "cur_pos", AppConstants.Key.SESSION_INFO, "first_show"}, new Object[]{null, 0, 0, ByteStringMicro.EMPTY, null}, guildSearchRecommendSvr$GetRecommendGroupRsp.class);
    public final PBRepeatMessageField<guildSearchRecommendSvr$RecommendGroup> recommend_groups = PBField.initRepeatMessage(guildSearchRecommendSvr$RecommendGroup.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBUInt32Field cur_pos = PBField.initUInt32(0);
    public final PBBytesField session_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public guildSearchRecommendSvr$FirstShow first_show = new guildSearchRecommendSvr$FirstShow();
}
