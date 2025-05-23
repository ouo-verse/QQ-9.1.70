package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$PkgResp extends MessageMicro<FestivalPack$PkgResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 42, 50, 58, 66, 98, 106}, new String[]{"get_eve_pack", "query_pack", "query_pack_list", "set_pack_used", "query_pack_list_h5", "query_promotion_pack_list", "set_block_user"}, new Object[]{null, null, null, null, null, null, null}, FestivalPack$PkgResp.class);
    public FestivalPack$NewYearEvePackResp get_eve_pack = new FestivalPack$NewYearEvePackResp();
    public FestivalPack$QueryPackResp query_pack = new MessageMicro<FestivalPack$QueryPackResp>() { // from class: tencent.im.new_year_2021.FestivalPack$QueryPackResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"pack"}, new Object[]{null}, FestivalPack$QueryPackResp.class);
        public Pack2021$Pack pack = new Pack2021$Pack();
    };
    public FestivalPack$QueryPackListResp query_pack_list = new MessageMicro<FestivalPack$QueryPackListResp>() { // from class: tencent.im.new_year_2021.FestivalPack$QueryPackListResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"from_index", "total_count", "count", "pack_list"}, new Object[]{0, 0, 0, null}, FestivalPack$QueryPackListResp.class);
        public final PBUInt32Field from_index = PBField.initUInt32(0);
        public final PBUInt32Field total_count = PBField.initUInt32(0);
        public final PBUInt32Field count = PBField.initUInt32(0);
        public final PBRepeatMessageField<Pack2021$Pack> pack_list = PBField.initRepeatMessage(Pack2021$Pack.class);
    };
    public FestivalPack$SetPackUsedResp set_pack_used = new MessageMicro<FestivalPack$SetPackUsedResp>() { // from class: tencent.im.new_year_2021.FestivalPack$SetPackUsedResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"business"}, new Object[]{0}, FestivalPack$SetPackUsedResp.class);
        public final PBUInt32Field business = PBField.initUInt32(0);
    };
    public FestivalPack$QueryPackListH5Resp query_pack_list_h5 = new MessageMicro<FestivalPack$QueryPackListH5Resp>() { // from class: tencent.im.new_year_2021.FestivalPack$QueryPackListH5Resp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"pack_list"}, new Object[]{null}, FestivalPack$QueryPackListH5Resp.class);
        public final PBRepeatMessageField<Pack2021$Pack> pack_list = PBField.initRepeatMessage(Pack2021$Pack.class);
    };
    public FestivalPack$QueryPromotionPackListResp query_promotion_pack_list = new MessageMicro<FestivalPack$QueryPromotionPackListResp>() { // from class: tencent.im.new_year_2021.FestivalPack$QueryPromotionPackListResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"pack_list"}, new Object[]{null}, FestivalPack$QueryPromotionPackListResp.class);
        public final PBRepeatMessageField<Pack2021$Pack> pack_list = PBField.initRepeatMessage(Pack2021$Pack.class);
    };
    public FestivalPack$SetBlockUserResp set_block_user = new MessageMicro<FestivalPack$SetBlockUserResp>() { // from class: tencent.im.new_year_2021.FestivalPack$SetBlockUserResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"errcode"}, new Object[]{0}, FestivalPack$SetBlockUserResp.class);
        public final PBUInt32Field errcode = PBField.initUInt32(0);
    };
}
