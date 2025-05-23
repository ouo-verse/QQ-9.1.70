package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$GetGameModeDetailRsp extends MessageMicro<GameDataServerOuterClass$GetGameModeDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"game_id", "item_list", "game_mode_index", "rank_index"}, new Object[]{0, null, 0, 0}, GameDataServerOuterClass$GetGameModeDetailRsp.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBRepeatMessageField<YesGameInfoOuterClass$GameConfigItem> item_list = PBField.initRepeatMessage(YesGameInfoOuterClass$GameConfigItem.class);
    public final PBInt32Field game_mode_index = PBField.initInt32(0);
    public final PBInt32Field rank_index = PBField.initInt32(0);
}
