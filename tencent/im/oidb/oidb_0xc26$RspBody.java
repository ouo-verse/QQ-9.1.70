package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc26$RspBody extends MessageMicro<oidb_0xc26$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 58, 64, 72, 80, 90, 96, 106, 114, 122}, new String[]{"rpt_msg_persons", "rpt_entry_inuse", "rpt_entry_close", "uint32_next_gap", "uint32_timestamp", "uint32_msg_up", "rpt_entry_delays", "uint32_list_switch", "uint32_add_page_list_switch", "em_rsp_data_type", "rpt_msg_rgroup_items", "bool_is_newuser", "rpt_msg_tables", "bytes_cookies", "rpt_msg_undecides"}, new Object[]{null, 1, 1, 0, 0, 0, null, 0, 0, 1, null, Boolean.FALSE, null, ByteStringMicro.EMPTY, null}, oidb_0xc26$RspBody.class);
    public final PBBoolField bool_is_newuser;
    public final PBBytesField bytes_cookies;
    public final PBEnumField em_rsp_data_type;
    public final PBRepeatField<Integer> rpt_entry_close;
    public final PBRepeatMessageField<oidb_0xc26$EntryDelay> rpt_entry_delays;
    public final PBRepeatField<Integer> rpt_entry_inuse;
    public final PBRepeatMessageField<oidb_0xc26$MayKnowPerson> rpt_msg_persons = PBField.initRepeatMessage(oidb_0xc26$MayKnowPerson.class);
    public final PBRepeatMessageField<oidb_0xc26$RecommendInfo> rpt_msg_rgroup_items;
    public final PBRepeatMessageField<oidb_0xc26$TabInfo> rpt_msg_tables;
    public final PBRepeatMessageField<oidb_0xc26$UndecidePerson> rpt_msg_undecides;
    public final PBUInt32Field uint32_add_page_list_switch;
    public final PBUInt32Field uint32_list_switch;
    public final PBUInt32Field uint32_msg_up;
    public final PBUInt32Field uint32_next_gap;
    public final PBUInt32Field uint32_timestamp;

    public oidb_0xc26$RspBody() {
        PBEnumField pBEnumField = PBEnumField.__repeatHelper__;
        this.rpt_entry_inuse = PBField.initRepeat(pBEnumField);
        this.rpt_entry_close = PBField.initRepeat(pBEnumField);
        this.uint32_next_gap = PBField.initUInt32(0);
        this.uint32_timestamp = PBField.initUInt32(0);
        this.uint32_msg_up = PBField.initUInt32(0);
        this.rpt_entry_delays = PBField.initRepeatMessage(oidb_0xc26$EntryDelay.class);
        this.uint32_list_switch = PBField.initUInt32(0);
        this.uint32_add_page_list_switch = PBField.initUInt32(0);
        this.em_rsp_data_type = PBField.initEnum(1);
        this.rpt_msg_rgroup_items = PBField.initRepeatMessage(oidb_0xc26$RecommendInfo.class);
        this.bool_is_newuser = PBField.initBool(false);
        this.rpt_msg_tables = PBField.initRepeatMessage(oidb_0xc26$TabInfo.class);
        this.bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
        this.rpt_msg_undecides = PBField.initRepeatMessage(oidb_0xc26$UndecidePerson.class);
    }
}
