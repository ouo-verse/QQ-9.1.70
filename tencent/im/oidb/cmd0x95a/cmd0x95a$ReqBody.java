package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x95a$ReqBody extends MessageMicro<cmd0x95a$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 810, 818, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO}, new String[]{"msg_update_ar_count_req", "msg_get_ar_count_list_req", "msg_get_ar_activity_list_req", "msg_get_ar_activity_detail_req", "msg_get_ar_activity_red_req", "msg_get_world_cup_info_req", "msg_set_world_cup_info_req", "msg_join_world_cup_req"}, new Object[]{null, null, null, null, null, null, null, null}, cmd0x95a$ReqBody.class);
    public cmd0x95a$UpdateArCountReq msg_update_ar_count_req = new MessageMicro<cmd0x95a$UpdateArCountReq>() { // from class: tencent.im.oidb.cmd0x95a.cmd0x95a$UpdateArCountReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_uin", "uint32_update_type", "uint32_count_type", "uint32_count_value"}, new Object[]{0L, 0, 0, 0}, cmd0x95a$UpdateArCountReq.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_update_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_count_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_count_value = PBField.initUInt32(0);
    };
    public cmd0x95a$GetArCountListReq msg_get_ar_count_list_req = new MessageMicro<cmd0x95a$GetArCountListReq>() { // from class: tencent.im.oidb.cmd0x95a.cmd0x95a$GetArCountListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_uin"}, new Object[]{0L}, cmd0x95a$GetArCountListReq.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    };
    public cmd0x95a$GetArActivityListReq msg_get_ar_activity_list_req = new MessageMicro<cmd0x95a$GetArActivityListReq>() { // from class: tencent.im.oidb.cmd0x95a.cmd0x95a$GetArActivityListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 37}, new String[]{"uint64_uin", "uint32_start_pos", "uint32_want_num", "fixed32_last_get_time"}, new Object[]{0L, 0, 0, 0}, cmd0x95a$GetArActivityListReq.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_start_pos = PBField.initUInt32(0);
        public final PBUInt32Field uint32_want_num = PBField.initUInt32(0);
        public final PBFixed32Field fixed32_last_get_time = PBField.initFixed32(0);
    };
    public cmd0x95a$GetArActivityDetailReq msg_get_ar_activity_detail_req = new MessageMicro<cmd0x95a$GetArActivityDetailReq>() { // from class: tencent.im.oidb.cmd0x95a.cmd0x95a$GetArActivityDetailReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_uin", "uint32_activity_id"}, new Object[]{0L, 0}, cmd0x95a$GetArActivityDetailReq.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_activity_id = PBField.initUInt32(0);
    };
    public cmd0x95a$GetArActivityRedReq msg_get_ar_activity_red_req = new cmd0x95a$GetArActivityRedReq();
    public cmd0x95a$GetWorldCupInfoReq msg_get_world_cup_info_req = new MessageMicro<cmd0x95a$GetWorldCupInfoReq>() { // from class: tencent.im.oidb.cmd0x95a.cmd0x95a$GetWorldCupInfoReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_share_id"}, new Object[]{""}, cmd0x95a$GetWorldCupInfoReq.class);
        public final PBStringField str_share_id = PBField.initString("");
    };
    public cmd0x95a$SetWorldCupInfoReq msg_set_world_cup_info_req = new MessageMicro<cmd0x95a$SetWorldCupInfoReq>() { // from class: tencent.im.oidb.cmd0x95a.cmd0x95a$SetWorldCupInfoReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_worldcup_info"}, new Object[]{null}, cmd0x95a$SetWorldCupInfoReq.class);
        public cmd0x95a$WorldCupInfo msg_worldcup_info = new cmd0x95a$WorldCupInfo();
    };
    public cmd0x95a$JoinWorldCupReq msg_join_world_cup_req = new MessageMicro<cmd0x95a$JoinWorldCupReq>() { // from class: tencent.im.oidb.cmd0x95a.cmd0x95a$JoinWorldCupReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_t_req_recommend_nick"}, new Object[]{0}, cmd0x95a$JoinWorldCupReq.class);
        public final PBUInt32Field uint32_t_req_recommend_nick = PBField.initUInt32(0);
    };
}
