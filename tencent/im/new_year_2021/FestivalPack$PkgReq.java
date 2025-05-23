package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class FestivalPack$PkgReq extends MessageMicro<FestivalPack$PkgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24, 50, 82, 90, 98, 114, 290, 298}, new String[]{"cmdtype", "from_id", "get_eve_pack", "query_pack", "query_pack_list", "set_pack_used", "query_pack_list_h5", "query_promotion_pack_list", "set_block_user"}, new Object[]{0, 0, null, null, null, null, null, null, null}, FestivalPack$PkgReq.class);
    public final PBUInt32Field cmdtype = PBField.initUInt32(0);
    public final PBUInt32Field from_id = PBField.initUInt32(0);
    public FestivalPack$NewYearEvePackReq get_eve_pack = new FestivalPack$NewYearEvePackReq();
    public FestivalPack$QueryPackReq query_pack = new MessageMicro<FestivalPack$QueryPackReq>() { // from class: tencent.im.new_year_2021.FestivalPack$QueryPackReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"pack_id", "skey", "from_id"}, new Object[]{ByteStringMicro.EMPTY, "", 0}, FestivalPack$QueryPackReq.class);
        public final PBBytesField pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBStringField skey = PBField.initString("");
        public final PBInt32Field from_id = PBField.initInt32(0);
    };
    public FestivalPack$QueryPackListReq query_pack_list = new MessageMicro<FestivalPack$QueryPackListReq>() { // from class: tencent.im.new_year_2021.FestivalPack$QueryPackListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"from_index", "count", "skey"}, new Object[]{0, 0, ""}, FestivalPack$QueryPackListReq.class);
        public final PBUInt32Field from_index = PBField.initUInt32(0);
        public final PBInt32Field count = PBField.initInt32(0);
        public final PBStringField skey = PBField.initString("");
    };
    public FestivalPack$SetPackUsedReq set_pack_used = new MessageMicro<FestivalPack$SetPackUsedReq>() { // from class: tencent.im.new_year_2021.FestivalPack$SetPackUsedReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"pack_id", "external", "skey"}, new Object[]{ByteStringMicro.EMPTY, Boolean.FALSE, ""}, FestivalPack$SetPackUsedReq.class);
        public final PBBytesField pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBoolField external = PBField.initBool(false);
        public final PBStringField skey = PBField.initString("");
    };
    public FestivalPack$QueryPackListH5Req query_pack_list_h5 = new MessageMicro<FestivalPack$QueryPackListH5Req>() { // from class: tencent.im.new_year_2021.FestivalPack$QueryPackListH5Req
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"action"}, new Object[]{0}, FestivalPack$QueryPackListH5Req.class);
        public final PBUInt32Field action = PBField.initUInt32(0);
    };
    public FestivalPack$QueryPromotionPackListReq query_promotion_pack_list = new MessageMicro<FestivalPack$QueryPromotionPackListReq>() { // from class: tencent.im.new_year_2021.FestivalPack$QueryPromotionPackListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"promotion_id"}, new Object[]{0}, FestivalPack$QueryPromotionPackListReq.class);
        public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    };
    public FestivalPack$SetBlockUserReq set_block_user = new MessageMicro<FestivalPack$SetBlockUserReq>() { // from class: tencent.im.new_year_2021.FestivalPack$SetBlockUserReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0L}, FestivalPack$SetBlockUserReq.class);
        public final PBUInt64Field uin = PBField.initUInt64(0);
    };
}
