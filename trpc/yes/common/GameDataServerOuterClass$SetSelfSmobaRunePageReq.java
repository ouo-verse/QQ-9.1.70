package trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$SetSelfSmobaRunePageReq extends MessageMicro<GameDataServerOuterClass$SetSelfSmobaRunePageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"uid", "rune_page_idx", "rune_str", GdtGetUserInfoHandler.KEY_AREA, "partition"}, new Object[]{0L, 0, "", 0, 0}, GameDataServerOuterClass$SetSelfSmobaRunePageReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt32Field rune_page_idx = PBField.initUInt32(0);
    public final PBStringField rune_str = PBField.initString("");
    public final PBUInt32Field area = PBField.initUInt32(0);
    public final PBUInt32Field partition = PBField.initUInt32(0);
}
