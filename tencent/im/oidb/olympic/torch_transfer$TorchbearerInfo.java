package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class torch_transfer$TorchbearerInfo extends MessageMicro<torch_transfer$TorchbearerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 66}, new String[]{"uint64_uin", "uint64_bearer_id", "uint32_transfer_num", "msg_pic_info", "msg_light_city_info", "msg_limit_info", "msg_business_entry_info", "msg_torcher_rank_info"}, new Object[]{0L, 0L, 0, null, null, null, null, null}, torch_transfer$TorchbearerInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_bearer_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_transfer_num = PBField.initUInt32(0);
    public torch_transfer$TorchPicInfo msg_pic_info = new MessageMicro<torch_transfer$TorchPicInfo>() { // from class: tencent.im.oidb.olympic.torch_transfer$TorchPicInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_business_type", "str_torch_pic_url", "str_torch_pic_md5", "rpt_city_pic_list"}, new Object[]{0, "", "", null}, torch_transfer$TorchPicInfo.class);
        public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
        public final PBStringField str_torch_pic_url = PBField.initString("");
        public final PBStringField str_torch_pic_md5 = PBField.initString("");
        public final PBRepeatMessageField<torch_transfer$CityBackPicInfo> rpt_city_pic_list = PBField.initRepeatMessage(torch_transfer$CityBackPicInfo.class);
    };
    public torch_transfer$LightCityInfo msg_light_city_info = new MessageMicro<torch_transfer$LightCityInfo>() { // from class: tencent.im.oidb.olympic.torch_transfer$LightCityInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_cur_city_id", "uint32_next_city_num"}, new Object[]{0, 0}, torch_transfer$LightCityInfo.class);
        public final PBUInt32Field uint32_cur_city_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_next_city_num = PBField.initUInt32(0);
    };
    public torch_transfer$TorchLimitInfo msg_limit_info = new MessageMicro<torch_transfer$TorchLimitInfo>() { // from class: tencent.im.oidb.olympic.torch_transfer$TorchLimitInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_timestamp", "bool_limit"}, new Object[]{0, Boolean.FALSE}, torch_transfer$TorchLimitInfo.class);
        public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
        public final PBBoolField bool_limit = PBField.initBool(false);
    };
    public torch_transfer$BusinessEntryInfo msg_business_entry_info = new MessageMicro<torch_transfer$BusinessEntryInfo>() { // from class: tencent.im.oidb.olympic.torch_transfer$BusinessEntryInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_business_entry_new", "uint32_business_entry_seq"}, new Object[]{0, 0}, torch_transfer$BusinessEntryInfo.class);
        public final PBUInt32Field uint32_business_entry_new = PBField.initUInt32(0);
        public final PBUInt32Field uint32_business_entry_seq = PBField.initUInt32(0);
    };
    public torch_transfer$TorcherRankInfo msg_torcher_rank_info = new MessageMicro<torch_transfer$TorcherRankInfo>() { // from class: tencent.im.oidb.olympic.torch_transfer$TorcherRankInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"bool_only_torcher", "uint32_rankings"}, new Object[]{Boolean.FALSE, 0}, torch_transfer$TorcherRankInfo.class);
        public final PBBoolField bool_only_torcher = PBField.initBool(false);
        public final PBUInt32Field uint32_rankings = PBField.initUInt32(0);
    };
}
