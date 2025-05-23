package tencent.im.oidb.cmd0x78f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x78f$ReqBody extends MessageMicro<oidb_0x78f$ReqBody> {
    public static final int ELEM_TYPE_LIST_FIELD_NUMBER = 14;
    public static final int GROUP_CODE_FIELD_NUMBER = 1;
    public static final int KEYWORD_LIST_FIELD_NUMBER = 2;
    public static final int MSG_LEN_MAX_FIELD_NUMBER = 9;
    public static final int MSG_LEN_MIN_FIELD_NUMBER = 8;
    public static final int MSG_SEQ_BEGIN_FIELD_NUMBER = 12;
    public static final int MSG_SEQ_END_FIELD_NUMBER = 13;
    public static final int NUM_PER_PAGE_FIELD_NUMBER = 3;
    public static final int PAGE_ID_FIELD_NUMBER = 4;
    public static final int RANK_TYPE_FIELD_NUMBER = 5;
    public static final int TIME_BEGIN_FIELD_NUMBER = 10;
    public static final int TIME_END_FIELD_NUMBER = 11;
    public static final int UIN_BLACK_LIST_FIELD_NUMBER = 7;
    public static final int UIN_WHITE_LIST_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112}, new String[]{"group_code", "keyword_list", "num_per_page", "page_id", "rank_type", "uin_white_list", "uin_black_list", "msg_len_min", "msg_len_max", "time_begin", "time_end", "msg_seq_begin", "msg_seq_end", "elem_type_list"}, new Object[]{0L, "", 20, 0, 0, 0L, 0L, -1, -1, 0, 0, 0, 0, 0}, oidb_0x78f$ReqBody.class);
    public static final oidb_0x78f$ReqBody __repeatHelper__ = new oidb_0x78f$ReqBody();
    public final PBRepeatField<Integer> elem_type_list;
    public final PBInt32Field msg_len_max;
    public final PBInt32Field msg_len_min;
    public final PBUInt32Field msg_seq_begin;
    public final PBUInt32Field msg_seq_end;
    public final PBInt32Field time_begin;
    public final PBInt32Field time_end;
    public final PBRepeatField<Long> uin_black_list;
    public final PBRepeatField<Long> uin_white_list;
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBRepeatField<String> keyword_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field num_per_page = PBField.initUInt32(20);
    public final PBUInt32Field page_id = PBField.initUInt32(0);
    public final PBInt32Field rank_type = PBField.initInt32(0);

    public oidb_0x78f$ReqBody() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.uin_white_list = PBField.initRepeat(pBUInt64Field);
        this.uin_black_list = PBField.initRepeat(pBUInt64Field);
        this.msg_len_min = PBField.initInt32(-1);
        this.msg_len_max = PBField.initInt32(-1);
        this.time_begin = PBField.initInt32(0);
        this.time_end = PBField.initInt32(0);
        this.msg_seq_begin = PBField.initUInt32(0);
        this.msg_seq_end = PBField.initUInt32(0);
        this.elem_type_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    }
}
