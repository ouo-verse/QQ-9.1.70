package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$SsoReq extends MessageMicro<FestivalPack$SsoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, FestivalPack$SsoReq.class);
    public FestivalPack$PkgReq data = new MessageMicro<FestivalPack$PkgReq>() { // from class: tencent.im.spring_hb.FestivalPack$PkgReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24, 50, 82, 90, 98}, new String[]{"cmdtype", "from_id", "get_eve_pack", "query_pack", "query_pack_list", "set_pack_used"}, new Object[]{0, 0, null, null, null, null}, FestivalPack$PkgReq.class);
        public final PBUInt32Field cmdtype = PBField.initUInt32(0);
        public final PBUInt32Field from_id = PBField.initUInt32(0);
        public FestivalPack$NewYearEvePackReq get_eve_pack = new FestivalPack$NewYearEvePackReq();
        public FestivalPack$QueryPackReq query_pack = new MessageMicro<FestivalPack$QueryPackReq>() { // from class: tencent.im.spring_hb.FestivalPack$QueryPackReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"pack_id", "skey", "from_id", "prize_id"}, new Object[]{"", "", 0, 0}, FestivalPack$QueryPackReq.class);
            public final PBStringField pack_id = PBField.initString("");
            public final PBStringField skey = PBField.initString("");
            public final PBUInt32Field from_id = PBField.initUInt32(0);
            public final PBUInt32Field prize_id = PBField.initUInt32(0);
        };
        public FestivalPack$QueryPackListReq query_pack_list = new MessageMicro<FestivalPack$QueryPackListReq>() { // from class: tencent.im.spring_hb.FestivalPack$QueryPackListReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 56}, new String[]{"from_index", "count", "skey", "promotion_id", "promotion_type", "from_id", "pack_type"}, new Object[]{0, 0, "", 0, 0, 0, 0}, FestivalPack$QueryPackListReq.class);
            public final PBUInt32Field from_index = PBField.initUInt32(0);
            public final PBInt32Field count = PBField.initInt32(0);
            public final PBStringField skey = PBField.initString("");
            public final PBUInt32Field promotion_id = PBField.initUInt32(0);
            public final PBUInt32Field promotion_type = PBField.initUInt32(0);
            public final PBUInt32Field from_id = PBField.initUInt32(0);
            public final PBUInt32Field pack_type = PBField.initUInt32(0);
        };
        public FestivalPack$SetPackUsedReq set_pack_used = new MessageMicro<FestivalPack$SetPackUsedReq>() { // from class: tencent.im.spring_hb.FestivalPack$SetPackUsedReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"pack_id", "external", "skey", "state", "from_id"}, new Object[]{"", Boolean.FALSE, "", 0, 0}, FestivalPack$SetPackUsedReq.class);
            public final PBStringField pack_id = PBField.initString("");
            public final PBBoolField external = PBField.initBool(false);
            public final PBStringField skey = PBField.initString("");
            public final PBInt32Field state = PBField.initInt32(0);
            public final PBUInt32Field from_id = PBField.initUInt32(0);
        };
    };
}
