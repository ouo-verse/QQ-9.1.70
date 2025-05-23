package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$PkgResp extends MessageMicro<FestivalPack$PkgResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 42, 50, 58}, new String[]{"errcode", "get_eve_pack", "query_pack", "query_pack_list", "set_pack_used"}, new Object[]{0, null, null, null, null}, FestivalPack$PkgResp.class);
    public final PBInt32Field errcode = PBField.initInt32(0);
    public FestivalPack$NewYearEvePackResp get_eve_pack = new FestivalPack$NewYearEvePackResp();
    public FestivalPack$QueryPackResp query_pack = new MessageMicro<FestivalPack$QueryPackResp>() { // from class: tencent.im.spring_hb.FestivalPack$QueryPackResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"pack"}, new Object[]{null}, FestivalPack$QueryPackResp.class);
        public FestivalPack$Pack pack = new FestivalPack$Pack();
    };
    public FestivalPack$QueryPackListResp query_pack_list = new MessageMicro<FestivalPack$QueryPackListResp>() { // from class: tencent.im.spring_hb.FestivalPack$QueryPackListResp
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field from_index = PBField.initUInt32(0);
        public final PBUInt32Field total_count = PBField.initUInt32(0);
        public final PBUInt32Field count = PBField.initUInt32(0);
        public final PBRepeatMessageField<FestivalPack$Pack> pack_list = PBField.initRepeatMessage(FestivalPack$Pack.class);
        public final PBUInt32Field total_money = PBField.initUInt32(0);
        public final PBUInt32Field total_coupon = PBField.initUInt32(0);
        public final PBBoolField reserve_zplan = PBField.initBool(false);
        public final PBBoolField has_reddot = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56, 64}, new String[]{"from_index", "total_count", "count", "pack_list", "total_money", "total_coupon", "reserve_zplan", "has_reddot"}, new Object[]{0, 0, 0, null, 0, 0, bool, bool}, FestivalPack$QueryPackListResp.class);
        }
    };
    public FestivalPack$SetPackUsedResp set_pack_used = new MessageMicro<FestivalPack$SetPackUsedResp>() { // from class: tencent.im.spring_hb.FestivalPack$SetPackUsedResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"business"}, new Object[]{0}, FestivalPack$SetPackUsedResp.class);
        public final PBUInt32Field business = PBField.initUInt32(0);
    };
}
