package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x95a$RspBody extends MessageMicro<cmd0x95a$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 810, 818, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO}, new String[]{"msg_update_ar_count_rsp", "msg_get_ar_count_list_rsp", "msg_get_ar_activity_list_rsp", "msg_get_ar_activity_detail_rsp", "msg_get_ar_activity_red_rsp", "msg_get_world_cup_info_rsp", "msg_set_world_cup_info_rsp", "msg_join_world_cup_rsp"}, new Object[]{null, null, null, null, null, null, null, null}, cmd0x95a$RspBody.class);
    public cmd0x95a$UpdateArCountRsp msg_update_ar_count_rsp = new cmd0x95a$UpdateArCountRsp();
    public cmd0x95a$GetArCountListRsp msg_get_ar_count_list_rsp = new MessageMicro<cmd0x95a$GetArCountListRsp>() { // from class: tencent.im.oidb.cmd0x95a.cmd0x95a$GetArCountListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "rpt_msg_ar_count_item"}, new Object[]{0L, null}, cmd0x95a$GetArCountListRsp.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBRepeatMessageField<cmd0x95a$ArCountItem> rpt_msg_ar_count_item = PBField.initRepeatMessage(cmd0x95a$ArCountItem.class);
    };
    public cmd0x95a$GetArActivityListRsp msg_get_ar_activity_list_rsp = new MessageMicro<cmd0x95a$GetArActivityListRsp>() { // from class: tencent.im.oidb.cmd0x95a.cmd0x95a$GetArActivityListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 21, 24, 32, 42}, new String[]{"uint64_uin", "fixed32_get_time", "uint32_completed", "uint32_now_pos", "rpt_msg_ar_activity_item"}, new Object[]{0L, 0, 0, 0, null}, cmd0x95a$GetArActivityListRsp.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBFixed32Field fixed32_get_time = PBField.initFixed32(0);
        public final PBUInt32Field uint32_completed = PBField.initUInt32(0);
        public final PBUInt32Field uint32_now_pos = PBField.initUInt32(0);
        public final PBRepeatMessageField<cmd0x95a$ArActivityItem> rpt_msg_ar_activity_item = PBField.initRepeatMessage(cmd0x95a$ArActivityItem.class);
    };
    public cmd0x95a$GetArActivityDetailRsp msg_get_ar_activity_detail_rsp = new MessageMicro<cmd0x95a$GetArActivityDetailRsp>() { // from class: tencent.im.oidb.cmd0x95a.cmd0x95a$GetArActivityDetailRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 66}, new String[]{"uint64_uin", "uint32_activity_id", "uint32_activity_type", "str_activity_name", "str_head_pic_url", "str_activity_desc", "rpt_str_identify_pic_url", "str_identify_pic_wording"}, new Object[]{0L, 0, 0, "", "", "", "", ""}, cmd0x95a$GetArActivityDetailRsp.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_activity_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_activity_type = PBField.initUInt32(0);
        public final PBStringField str_activity_name = PBField.initString("");
        public final PBStringField str_head_pic_url = PBField.initString("");
        public final PBStringField str_activity_desc = PBField.initString("");
        public final PBRepeatField<String> rpt_str_identify_pic_url = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField str_identify_pic_wording = PBField.initString("");
    };
    public cmd0x95a$GetArActivityRedRsp msg_get_ar_activity_red_rsp = new cmd0x95a$GetArActivityRedRsp();
    public cmd0x95a$GetWorldCupInfoRsp msg_get_world_cup_info_rsp = new MessageMicro<cmd0x95a$GetWorldCupInfoRsp>() { // from class: tencent.im.oidb.cmd0x95a.cmd0x95a$GetWorldCupInfoRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_worldcup_info"}, new Object[]{null}, cmd0x95a$GetWorldCupInfoRsp.class);
        public cmd0x95a$WorldCupInfo msg_worldcup_info = new cmd0x95a$WorldCupInfo();
    };
    public cmd0x95a$SetWorldCupInfoRsp msg_set_world_cup_info_rsp = new MessageMicro<cmd0x95a$SetWorldCupInfoRsp>() { // from class: tencent.im.oidb.cmd0x95a.cmd0x95a$SetWorldCupInfoRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_share_id"}, new Object[]{""}, cmd0x95a$SetWorldCupInfoRsp.class);
        public final PBStringField str_share_id = PBField.initString("");
    };
    public cmd0x95a$JoinWorldCupRsp msg_join_world_cup_rsp = new MessageMicro<cmd0x95a$JoinWorldCupRsp>() { // from class: tencent.im.oidb.cmd0x95a.cmd0x95a$JoinWorldCupRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_recommend_uin", "str_recommend_nick"}, new Object[]{0L, ""}, cmd0x95a$JoinWorldCupRsp.class);
        public final PBUInt64Field uint64_recommend_uin = PBField.initUInt64(0);
        public final PBStringField str_recommend_nick = PBField.initString("");
    };
}
