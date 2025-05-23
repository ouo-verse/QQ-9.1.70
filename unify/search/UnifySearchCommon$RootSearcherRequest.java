package unify.search;

import com.tencent.luggage.wxa.xd.m0;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UnifySearchCommon$RootSearcherRequest extends MessageMicro<UnifySearchCommon$RootSearcherRequest> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookie;
    public final PBBytesField json_data;
    public final PBBytesField ocean_data;
    public final PBBytesField qua;
    public final PBRepeatField<ByteStringMicro> query_cate;
    public final PBUInt32Field query_ctrl_flag;
    public final PBUInt32Field query_rewrite;
    public UnifySearchCommon$ItemRequestBusiMask request_busi_mask;
    public final PBUInt32Field use_all_mask;
    public final PBRepeatMessageField<UnifySearchCommon$ItemRequestUserData> user_data_list;
    public final PBUInt32Field business = PBField.initUInt32(0);
    public final PBUInt32Field page_size = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_busi_mask = PBField.initRepeat(PBUInt64Field.__repeatHelper__);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 32, 80, 90, 402, 408, 418, 424, 434, 442, TroopInfo.PAY_PRIVILEGE_ALL, 458, m0.CTRL_INDEX}, new String[]{"business", "page_size", "rpt_busi_mask", "cookie", "ocean_data", "use_all_mask", "query_cate", "query_rewrite", "qua", "json_data", "query_ctrl_flag", "user_data_list", "request_busi_mask"}, new Object[]{0, 0, 0L, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0, null, null}, UnifySearchCommon$RootSearcherRequest.class);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [unify.search.UnifySearchCommon$ItemRequestBusiMask] */
    public UnifySearchCommon$RootSearcherRequest() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.cookie = PBField.initBytes(byteStringMicro);
        this.ocean_data = PBField.initBytes(byteStringMicro);
        this.use_all_mask = PBField.initUInt32(0);
        this.query_cate = PBField.initRepeat(PBBytesField.__repeatHelper__);
        this.query_rewrite = PBField.initUInt32(0);
        this.qua = PBField.initBytes(byteStringMicro);
        this.json_data = PBField.initBytes(byteStringMicro);
        this.query_ctrl_flag = PBField.initUInt32(0);
        this.user_data_list = PBField.initRepeatMessage(UnifySearchCommon$ItemRequestUserData.class);
        this.request_busi_mask = new MessageMicro<UnifySearchCommon$ItemRequestBusiMask>() { // from class: unify.search.UnifySearchCommon$ItemRequestBusiMask
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"group_mask", AppConstants.Key.SESSION_INFO}, new Object[]{0L, ByteStringMicro.EMPTY}, UnifySearchCommon$ItemRequestBusiMask.class);
            public final PBUInt64Field group_mask = PBField.initUInt64(0);
            public final PBBytesField session_info = PBField.initBytes(ByteStringMicro.EMPTY);
        };
    }
}
