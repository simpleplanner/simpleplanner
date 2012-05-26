package planner.strips.pddl.parser;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class PddlLexer extends Lexer {
    public static final int REQUIRE_KEY=45;
    public static final int FUNCTIONS=10;
    public static final int LETTER=48;
    public static final int PRED_INST=41;
    public static final int TYPES=7;
    public static final int EXISTS_GD=26;
    public static final int EOF=-1;
    public static final int COMPARISON_GD=28;
    public static final int ACTION=12;
    public static final int T__93=93;
    public static final int ANY_CHAR=49;
    public static final int T__94=94;
    public static final int NOT_EFFECT=33;
    public static final int T__91=91;
    public static final int NAME=44;
    public static final int T__92=92;
    public static final int T__90=90;
    public static final int OBJECTS=17;
    public static final int PROBLEM_DOMAIN=16;
    public static final int ASSIGN_EFFECT=32;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int LINE_COMMENT=51;
    public static final int PROBLEM=14;
    public static final int NUMBER=47;
    public static final int WHITESPACE=52;
    public static final int UNARY_MINUS=37;
    public static final int OR_GD=23;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int DOMAIN_NAME=5;
    public static final int PRED_HEAD=34;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int PREDICATES=11;
    public static final int VARIABLE=46;
    public static final int T__70=70;
    public static final int INIT_AT=39;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int INIT=18;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int AND_GD=22;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int FUNC_HEAD=19;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int PROBLEM_NAME=15;
    public static final int NOT_GD=24;
    public static final int T__118=118;
    public static final int DURATIVE_ACTION=13;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int PROBLEM_METRIC=43;
    public static final int CONSTANTS=9;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int IMPLY_GD=25;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__103=103;
    public static final int T__59=59;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int INIT_EQ=38;
    public static final int DIGIT=50;
    public static final int NOT_PRED_INIT=40;
    public static final int GOAL=35;
    public static final int BINARY_OP=36;
    public static final int FORALL_GD=27;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int DOMAIN=4;
    public static final int WHEN_EFFECT=31;
    public static final int PRECONDITION=20;
    public static final int EFFECT=21;
    public static final int AND_EFFECT=29;
    public static final int PROBLEM_CONSTRAINT=42;
    public static final int EITHER_TYPE=8;
    public static final int FORALL_EFFECT=30;
    public static final int REQUIREMENTS=6;

    // delegates
    // delegators

    public PddlLexer() {;} 
    public PddlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PddlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g"; }

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:5:7: ( '(' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:5:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:6:7: ( 'define' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:6:9: 'define'
            {
            match("define"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:7:7: ( ')' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:7:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:8:7: ( 'domain' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:8:9: 'domain'
            {
            match("domain"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:9:7: ( ':requirements' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:9:9: ':requirements'
            {
            match(":requirements"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:10:7: ( ':types' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:10:9: ':types'
            {
            match(":types"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:11:7: ( '-' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:11:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:12:7: ( 'either' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:12:9: 'either'
            {
            match("either"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:13:7: ( ':functions' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:13:9: ':functions'
            {
            match(":functions"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:14:7: ( 'number' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:14:9: 'number'
            {
            match("number"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:15:7: ( ':constants' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:15:9: ':constants'
            {
            match(":constants"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:16:7: ( ':predicates' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:16:9: ':predicates'
            {
            match(":predicates"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:17:7: ( ':constraints' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:17:9: ':constraints'
            {
            match(":constraints"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:18:7: ( ':action' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:18:9: ':action'
            {
            match(":action"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:19:7: ( ':parameters' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:19:9: ':parameters'
            {
            match(":parameters"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:20:7: ( ':precondition' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:20:9: ':precondition'
            {
            match(":precondition"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:21:7: ( ':effect' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:21:9: ':effect'
            {
            match(":effect"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:22:7: ( 'and' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:22:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:23:7: ( 'or' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:23:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:24:7: ( 'not' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:24:9: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:25:7: ( 'imply' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:25:9: 'imply'
            {
            match("imply"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:26:7: ( 'exists' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:26:9: 'exists'
            {
            match("exists"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:27:7: ( 'forall' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:27:9: 'forall'
            {
            match("forall"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:28:7: ( ':durative-action' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:28:9: ':durative-action'
            {
            match(":durative-action"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:29:7: ( ':duration' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:29:9: ':duration'
            {
            match(":duration"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:30:7: ( ':condition' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:30:9: ':condition'
            {
            match(":condition"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:31:7: ( 'preference' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:31:9: 'preference'
            {
            match("preference"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:32:7: ( 'at' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:32:9: 'at'
            {
            match("at"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:33:7: ( 'over' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:33:9: 'over'
            {
            match("over"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:34:7: ( 'start' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:34:9: 'start'
            {
            match("start"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:35:7: ( 'end' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:35:9: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:36:7: ( 'all' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:36:9: 'all'
            {
            match("all"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:37:7: ( ':derived' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:37:9: ':derived'
            {
            match(":derived"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:38:7: ( 'when' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:38:9: 'when'
            {
            match("when"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:39:7: ( '*' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:39:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:40:7: ( '+' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:40:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:41:7: ( '/' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:41:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:42:7: ( '>' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:42:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:43:7: ( '<' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:43:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:44:7: ( '=' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:44:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:45:7: ( '>=' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:45:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:46:7: ( '<=' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:46:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:47:7: ( 'assign' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:47:9: 'assign'
            {
            match("assign"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:48:7: ( 'scale-up' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:48:9: 'scale-up'
            {
            match("scale-up"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:49:7: ( 'scale-down' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:49:9: 'scale-down'
            {
            match("scale-down"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:50:7: ( 'increase' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:50:9: 'increase'
            {
            match("increase"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:51:7: ( 'decrease' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:51:9: 'decrease'
            {
            match("decrease"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:52:8: ( '?duration' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:52:10: '?duration'
            {
            match("?duration"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:53:8: ( 'problem' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:53:10: 'problem'
            {
            match("problem"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:54:8: ( ':domain' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:54:10: ':domain'
            {
            match(":domain"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:55:8: ( ':objects' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:55:10: ':objects'
            {
            match(":objects"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:56:8: ( ':init' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:56:10: ':init'
            {
            match(":init"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:57:8: ( ':goal' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:57:10: ':goal'
            {
            match(":goal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:58:8: ( ':metric' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:58:10: ':metric'
            {
            match(":metric"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:59:8: ( 'minimize' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:59:10: 'minimize'
            {
            match("minimize"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "T__108"
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:60:8: ( 'maximize' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:60:10: 'maximize'
            {
            match("maximize"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__108"

    // $ANTLR start "T__109"
    public final void mT__109() throws RecognitionException {
        try {
            int _type = T__109;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:61:8: ( 'total-time' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:61:10: 'total-time'
            {
            match("total-time"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__109"

    // $ANTLR start "T__110"
    public final void mT__110() throws RecognitionException {
        try {
            int _type = T__110;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:62:8: ( 'is-violated' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:62:10: 'is-violated'
            {
            match("is-violated"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__110"

    // $ANTLR start "T__111"
    public final void mT__111() throws RecognitionException {
        try {
            int _type = T__111;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:63:8: ( 'always' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:63:10: 'always'
            {
            match("always"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__111"

    // $ANTLR start "T__112"
    public final void mT__112() throws RecognitionException {
        try {
            int _type = T__112;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:64:8: ( 'sometime' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:64:10: 'sometime'
            {
            match("sometime"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__112"

    // $ANTLR start "T__113"
    public final void mT__113() throws RecognitionException {
        try {
            int _type = T__113;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:65:8: ( 'within' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:65:10: 'within'
            {
            match("within"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__113"

    // $ANTLR start "T__114"
    public final void mT__114() throws RecognitionException {
        try {
            int _type = T__114;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:66:8: ( 'at-most-once' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:66:10: 'at-most-once'
            {
            match("at-most-once"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__114"

    // $ANTLR start "T__115"
    public final void mT__115() throws RecognitionException {
        try {
            int _type = T__115;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:67:8: ( 'sometime-after' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:67:10: 'sometime-after'
            {
            match("sometime-after"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__115"

    // $ANTLR start "T__116"
    public final void mT__116() throws RecognitionException {
        try {
            int _type = T__116;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:68:8: ( 'sometime-before' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:68:10: 'sometime-before'
            {
            match("sometime-before"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__116"

    // $ANTLR start "T__117"
    public final void mT__117() throws RecognitionException {
        try {
            int _type = T__117;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:69:8: ( 'always-within' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:69:10: 'always-within'
            {
            match("always-within"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__117"

    // $ANTLR start "T__118"
    public final void mT__118() throws RecognitionException {
        try {
            int _type = T__118;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:70:8: ( 'hold-during' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:70:10: 'hold-during'
            {
            match("hold-during"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__118"

    // $ANTLR start "T__119"
    public final void mT__119() throws RecognitionException {
        try {
            int _type = T__119;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:71:8: ( 'hold-after' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:71:10: 'hold-after'
            {
            match("hold-after"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__119"

    // $ANTLR start "REQUIRE_KEY"
    public final void mREQUIRE_KEY() throws RecognitionException {
        try {
            int _type = REQUIRE_KEY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:499:5: ( ':strips' | ':typing' | ':negative-preconditions' | ':disjunctive-preconditions' | ':equality' | ':existential-preconditions' | ':universal-preconditions' | ':quantified-preconditions' | ':conditional-effects' | ':fluents' | ':adl' | ':durative-actions' | ':derived-predicates' | ':timed-initial-literals' | ':preferences' | ':constraints' )
            int alt1=16;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:499:7: ':strips'
                    {
                    match(":strips"); 


                    }
                    break;
                case 2 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:500:7: ':typing'
                    {
                    match(":typing"); 


                    }
                    break;
                case 3 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:501:7: ':negative-preconditions'
                    {
                    match(":negative-preconditions"); 


                    }
                    break;
                case 4 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:502:7: ':disjunctive-preconditions'
                    {
                    match(":disjunctive-preconditions"); 


                    }
                    break;
                case 5 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:503:7: ':equality'
                    {
                    match(":equality"); 


                    }
                    break;
                case 6 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:504:7: ':existential-preconditions'
                    {
                    match(":existential-preconditions"); 


                    }
                    break;
                case 7 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:505:7: ':universal-preconditions'
                    {
                    match(":universal-preconditions"); 


                    }
                    break;
                case 8 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:506:7: ':quantified-preconditions'
                    {
                    match(":quantified-preconditions"); 


                    }
                    break;
                case 9 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:507:7: ':conditional-effects'
                    {
                    match(":conditional-effects"); 


                    }
                    break;
                case 10 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:508:7: ':fluents'
                    {
                    match(":fluents"); 


                    }
                    break;
                case 11 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:509:7: ':adl'
                    {
                    match(":adl"); 


                    }
                    break;
                case 12 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:510:7: ':durative-actions'
                    {
                    match(":durative-actions"); 


                    }
                    break;
                case 13 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:511:7: ':derived-predicates'
                    {
                    match(":derived-predicates"); 


                    }
                    break;
                case 14 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:512:7: ':timed-initial-literals'
                    {
                    match(":timed-initial-literals"); 


                    }
                    break;
                case 15 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:513:7: ':preferences'
                    {
                    match(":preferences"); 


                    }
                    break;
                case 16 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:514:7: ':constraints'
                    {
                    match(":constraints"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REQUIRE_KEY"

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:518:5: ( LETTER ( ANY_CHAR )* )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:518:10: LETTER ( ANY_CHAR )*
            {
            mLETTER(); 
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:518:17: ( ANY_CHAR )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='-'||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:518:17: ANY_CHAR
            	    {
            	    mANY_CHAR(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NAME"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:520:16: ( 'a' .. 'z' | 'A' .. 'Z' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "ANY_CHAR"
    public final void mANY_CHAR() throws RecognitionException {
        try {
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:522:18: ( LETTER | '0' .. '9' | '-' | '_' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:
            {
            if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "ANY_CHAR"

    // $ANTLR start "VARIABLE"
    public final void mVARIABLE() throws RecognitionException {
        try {
            int _type = VARIABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:524:10: ( '?' LETTER ( ANY_CHAR )* )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:524:12: '?' LETTER ( ANY_CHAR )*
            {
            match('?'); 
            mLETTER(); 
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:524:23: ( ANY_CHAR )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='-'||(LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:524:23: ANY_CHAR
            	    {
            	    mANY_CHAR(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VARIABLE"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:526:8: ( ( DIGIT )+ ( '.' ( DIGIT )+ )? )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:526:10: ( DIGIT )+ ( '.' ( DIGIT )+ )?
            {
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:526:10: ( DIGIT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:526:10: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:526:17: ( '.' ( DIGIT )+ )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='.') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:526:18: '.' ( DIGIT )+
                    {
                    match('.'); 
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:526:22: ( DIGIT )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:526:22: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:528:15: ( '0' .. '9' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:528:17: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:531:5: ( ';' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:531:7: ';' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match(';'); 
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:531:11: (~ ( '\\n' | '\\r' ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:531:11: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:531:25: ( '\\r' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\r') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:531:25: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:535:5: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:535:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:535:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\t' && LA9_0<='\n')||LA9_0=='\r'||LA9_0==' ') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    public void mTokens() throws RecognitionException {
        // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:8: ( T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | REQUIRE_KEY | NAME | VARIABLE | NUMBER | LINE_COMMENT | WHITESPACE )
        int alt10=73;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:10: T__53
                {
                mT__53(); 

                }
                break;
            case 2 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:16: T__54
                {
                mT__54(); 

                }
                break;
            case 3 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:22: T__55
                {
                mT__55(); 

                }
                break;
            case 4 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:28: T__56
                {
                mT__56(); 

                }
                break;
            case 5 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:34: T__57
                {
                mT__57(); 

                }
                break;
            case 6 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:40: T__58
                {
                mT__58(); 

                }
                break;
            case 7 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:46: T__59
                {
                mT__59(); 

                }
                break;
            case 8 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:52: T__60
                {
                mT__60(); 

                }
                break;
            case 9 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:58: T__61
                {
                mT__61(); 

                }
                break;
            case 10 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:64: T__62
                {
                mT__62(); 

                }
                break;
            case 11 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:70: T__63
                {
                mT__63(); 

                }
                break;
            case 12 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:76: T__64
                {
                mT__64(); 

                }
                break;
            case 13 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:82: T__65
                {
                mT__65(); 

                }
                break;
            case 14 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:88: T__66
                {
                mT__66(); 

                }
                break;
            case 15 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:94: T__67
                {
                mT__67(); 

                }
                break;
            case 16 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:100: T__68
                {
                mT__68(); 

                }
                break;
            case 17 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:106: T__69
                {
                mT__69(); 

                }
                break;
            case 18 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:112: T__70
                {
                mT__70(); 

                }
                break;
            case 19 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:118: T__71
                {
                mT__71(); 

                }
                break;
            case 20 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:124: T__72
                {
                mT__72(); 

                }
                break;
            case 21 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:130: T__73
                {
                mT__73(); 

                }
                break;
            case 22 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:136: T__74
                {
                mT__74(); 

                }
                break;
            case 23 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:142: T__75
                {
                mT__75(); 

                }
                break;
            case 24 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:148: T__76
                {
                mT__76(); 

                }
                break;
            case 25 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:154: T__77
                {
                mT__77(); 

                }
                break;
            case 26 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:160: T__78
                {
                mT__78(); 

                }
                break;
            case 27 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:166: T__79
                {
                mT__79(); 

                }
                break;
            case 28 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:172: T__80
                {
                mT__80(); 

                }
                break;
            case 29 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:178: T__81
                {
                mT__81(); 

                }
                break;
            case 30 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:184: T__82
                {
                mT__82(); 

                }
                break;
            case 31 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:190: T__83
                {
                mT__83(); 

                }
                break;
            case 32 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:196: T__84
                {
                mT__84(); 

                }
                break;
            case 33 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:202: T__85
                {
                mT__85(); 

                }
                break;
            case 34 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:208: T__86
                {
                mT__86(); 

                }
                break;
            case 35 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:214: T__87
                {
                mT__87(); 

                }
                break;
            case 36 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:220: T__88
                {
                mT__88(); 

                }
                break;
            case 37 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:226: T__89
                {
                mT__89(); 

                }
                break;
            case 38 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:232: T__90
                {
                mT__90(); 

                }
                break;
            case 39 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:238: T__91
                {
                mT__91(); 

                }
                break;
            case 40 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:244: T__92
                {
                mT__92(); 

                }
                break;
            case 41 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:250: T__93
                {
                mT__93(); 

                }
                break;
            case 42 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:256: T__94
                {
                mT__94(); 

                }
                break;
            case 43 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:262: T__95
                {
                mT__95(); 

                }
                break;
            case 44 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:268: T__96
                {
                mT__96(); 

                }
                break;
            case 45 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:274: T__97
                {
                mT__97(); 

                }
                break;
            case 46 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:280: T__98
                {
                mT__98(); 

                }
                break;
            case 47 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:286: T__99
                {
                mT__99(); 

                }
                break;
            case 48 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:292: T__100
                {
                mT__100(); 

                }
                break;
            case 49 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:299: T__101
                {
                mT__101(); 

                }
                break;
            case 50 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:306: T__102
                {
                mT__102(); 

                }
                break;
            case 51 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:313: T__103
                {
                mT__103(); 

                }
                break;
            case 52 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:320: T__104
                {
                mT__104(); 

                }
                break;
            case 53 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:327: T__105
                {
                mT__105(); 

                }
                break;
            case 54 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:334: T__106
                {
                mT__106(); 

                }
                break;
            case 55 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:341: T__107
                {
                mT__107(); 

                }
                break;
            case 56 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:348: T__108
                {
                mT__108(); 

                }
                break;
            case 57 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:355: T__109
                {
                mT__109(); 

                }
                break;
            case 58 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:362: T__110
                {
                mT__110(); 

                }
                break;
            case 59 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:369: T__111
                {
                mT__111(); 

                }
                break;
            case 60 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:376: T__112
                {
                mT__112(); 

                }
                break;
            case 61 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:383: T__113
                {
                mT__113(); 

                }
                break;
            case 62 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:390: T__114
                {
                mT__114(); 

                }
                break;
            case 63 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:397: T__115
                {
                mT__115(); 

                }
                break;
            case 64 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:404: T__116
                {
                mT__116(); 

                }
                break;
            case 65 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:411: T__117
                {
                mT__117(); 

                }
                break;
            case 66 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:418: T__118
                {
                mT__118(); 

                }
                break;
            case 67 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:425: T__119
                {
                mT__119(); 

                }
                break;
            case 68 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:432: REQUIRE_KEY
                {
                mREQUIRE_KEY(); 

                }
                break;
            case 69 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:444: NAME
                {
                mNAME(); 

                }
                break;
            case 70 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:449: VARIABLE
                {
                mVARIABLE(); 

                }
                break;
            case 71 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:458: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 72 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:465: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 73 :
                // D:\\Java\\Lib\\antlr\\abcl-bin-1.0.1\\examples-v3\\java\\pddl\\Pddl.g:1:478: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;

        }

    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA1_eotS =
        "\30\uffff";
    static final String DFA1_eofS =
        "\30\uffff";
    static final String DFA1_minS =
        "\1\72\1\141\1\uffff\1\151\1\uffff\1\145\1\161\2\uffff\1\157\12"+
        "\uffff\1\156\1\144\2\uffff";
    static final String DFA1_maxS =
        "\1\72\1\165\1\uffff\1\171\1\uffff\1\165\1\170\2\uffff\1\157\12"+
        "\uffff\1\156\1\163\2\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\1\1\uffff\1\3\2\uffff\1\7\1\10\1\uffff\1\12\1\13\1\17"+
        "\1\2\1\16\1\4\1\14\1\15\1\5\1\6\2\uffff\1\11\1\20";
    static final String DFA1_specialS =
        "\30\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\1",
            "\1\13\1\uffff\1\11\1\5\1\6\1\12\7\uffff\1\4\1\uffff\1\14\1"+
            "\10\1\uffff\1\2\1\3\1\7",
            "",
            "\1\16\17\uffff\1\15",
            "",
            "\1\21\3\uffff\1\17\13\uffff\1\20",
            "\1\22\6\uffff\1\23",
            "",
            "",
            "\1\24",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\25",
            "\1\26\16\uffff\1\27",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "495:1: REQUIRE_KEY : ( ':strips' | ':typing' | ':negative-preconditions' | ':disjunctive-preconditions' | ':equality' | ':existential-preconditions' | ':universal-preconditions' | ':quantified-preconditions' | ':conditional-effects' | ':fluents' | ':adl' | ':durative-actions' | ':derived-predicates' | ':timed-initial-literals' | ':preferences' | ':constraints' );";
        }
    }
    static final String DFA10_eotS =
        "\2\uffff\1\31\3\uffff\11\31\3\uffff\1\102\1\104\2\uffff\3\31\4"+
        "\uffff\2\31\15\uffff\6\31\1\137\2\31\1\143\13\31\4\uffff\1\106\1"+
        "\uffff\7\31\12\uffff\2\31\1\177\1\31\1\u0081\1\u0082\1\31\1\uffff"+
        "\1\u0084\2\31\1\uffff\14\31\1\106\7\31\5\uffff\2\31\1\uffff\1\31"+
        "\2\uffff\1\31\1\uffff\2\31\1\u00a8\11\31\1\u00b2\1\31\1\106\7\31"+
        "\7\uffff\6\31\1\uffff\1\u00c6\5\31\1\u00cc\2\31\1\uffff\1\31\1\106"+
        "\4\31\1\u00d6\1\31\1\u00d8\4\uffff\1\u00de\1\u00df\1\u00e0\1\31"+
        "\1\u00e3\1\u00e4\1\uffff\2\31\1\u00e7\2\31\1\uffff\2\31\1\u00ed"+
        "\1\106\5\31\1\uffff\1\31\11\uffff\2\31\2\uffff\2\31\1\uffff\1\31"+
        "\1\u00ff\3\31\1\uffff\1\106\5\31\1\u0109\4\uffff\1\u010d\2\31\1"+
        "\u0110\2\31\1\uffff\1\u0113\1\31\1\u0116\1\106\1\u0118\1\u0119\3"+
        "\31\5\uffff\2\31\1\uffff\2\31\1\uffff\2\31\1\uffff\1\u0127\2\uffff"+
        "\3\31\1\uffff\1\u012c\1\uffff\3\31\1\u0131\1\u0132\2\31\1\uffff"+
        "\1\u0135\1\31\1\u0137\3\uffff\2\31\1\u013c\2\uffff\2\31\1\uffff"+
        "\1\u013f\3\uffff\1\u0142\1\31\1\uffff\2\31\4\uffff\1\u0147\2\31"+
        "\2\uffff\1\u014b\1\31\2\uffff\1\u014e\1\u014f\2\uffff";
    static final String DFA10_eofS =
        "\u0150\uffff";
    static final String DFA10_minS =
        "\1\11\1\uffff\1\145\1\uffff\1\141\1\uffff\1\151\1\157\1\154\1\162"+
        "\1\155\1\157\1\162\1\143\1\150\3\uffff\2\75\1\uffff\1\101\1\141"+
        "\2\157\4\uffff\1\143\1\155\1\uffff\1\151\1\154\1\157\1\141\1\143"+
        "\1\146\1\145\5\uffff\1\164\1\151\1\144\1\155\1\164\1\144\1\55\1"+
        "\154\1\163\1\55\1\145\1\160\1\143\1\55\1\162\1\145\2\141\1\155\1"+
        "\145\1\164\4\uffff\1\165\1\uffff\1\156\1\170\1\164\1\154\1\151\1"+
        "\162\1\141\1\160\1\uffff\1\156\1\145\3\uffff\2\162\1\uffff\1\150"+
        "\1\163\1\55\1\142\2\55\1\155\1\uffff\1\55\1\141\1\151\1\uffff\1"+
        "\162\1\154\1\162\1\166\1\141\1\146\1\142\1\162\1\154\1\145\1\156"+
        "\1\150\1\162\2\151\1\141\1\144\1\156\1\145\1\151\1\145\1\144\1\143"+
        "\1\141\1\151\1\145\1\164\1\uffff\1\145\2\uffff\1\157\1\uffff\1\171"+
        "\1\147\1\55\1\171\1\145\1\151\1\154\1\145\1\154\1\164\1\145\1\164"+
        "\1\55\1\151\1\141\2\155\1\154\1\55\1\145\1\141\1\156\1\uffff\1\164"+
        "\1\151\2\uffff\1\164\1\166\1\162\1\163\1\162\2\163\1\156\1\uffff"+
        "\1\55\1\141\1\157\1\154\1\162\1\145\2\55\1\151\1\uffff\1\156\1\164"+
        "\2\151\1\55\1\141\1\55\1\163\1\55\1\141\1\164\1\151\1\145\3\55\1"+
        "\164\2\55\1\uffff\1\163\1\154\1\55\1\145\1\155\1\uffff\1\144\1\155"+
        "\1\55\1\151\2\172\1\164\1\165\1\146\1\uffff\1\145\2\uffff\1\141"+
        "\1\151\1\157\1\144\3\uffff\1\55\1\167\2\uffff\1\145\1\141\1\uffff"+
        "\1\156\1\55\1\160\1\157\1\145\1\uffff\1\157\2\145\1\151\1\162\1"+
        "\164\1\55\1\151\1\157\1\145\1\uffff\1\55\1\157\1\151\1\55\1\164"+
        "\1\143\1\uffff\1\55\1\167\1\55\1\156\2\55\1\155\1\151\1\145\1\uffff"+
        "\2\156\1\55\1\uffff\1\156\1\164\1\uffff\2\145\1\uffff\1\156\1\141"+
        "\1\uffff\1\55\2\uffff\1\145\1\156\1\162\1\164\2\141\1\143\1\150"+
        "\1\144\2\55\1\146\1\145\1\uffff\1\55\1\147\1\55\1\163\1\uffff\1"+
        "\143\1\145\1\151\1\55\2\uffff\1\164\1\146\1\uffff\1\55\2\uffff\1"+
        "\164\1\55\1\156\1\uffff\1\145\1\157\2\uffff\1\151\1\uffff\1\55\2"+
        "\162\1\157\1\uffff\1\55\1\145\1\156\1\uffff\1\55\1\163\2\uffff";
    static final String DFA10_maxS =
        "\1\172\1\uffff\1\157\1\uffff\1\165\1\uffff\1\170\1\165\1\164\1"+
        "\166\1\163\1\157\1\162\1\164\1\151\3\uffff\2\75\1\uffff\1\172\1"+
        "\151\2\157\4\uffff\1\146\1\155\1\uffff\1\171\1\165\1\157\1\162\1"+
        "\144\1\170\1\165\5\uffff\1\164\1\151\1\144\1\155\1\164\1\144\1\172"+
        "\1\167\1\163\1\172\1\145\1\160\1\143\1\55\1\162\1\157\2\141\1\155"+
        "\1\145\1\164\4\uffff\1\165\1\uffff\1\156\1\170\1\164\1\154\1\151"+
        "\1\162\1\141\1\160\1\uffff\1\156\1\145\3\uffff\2\162\1\uffff\1\150"+
        "\1\163\1\172\1\142\2\172\1\155\1\uffff\1\172\1\141\1\151\1\uffff"+
        "\1\162\1\154\1\162\1\166\1\141\1\146\1\142\1\162\1\154\1\145\1\156"+
        "\1\150\1\162\2\151\1\141\1\144\1\156\1\145\2\151\1\163\1\146\1\141"+
        "\1\151\1\145\1\164\1\uffff\1\145\2\uffff\1\157\1\uffff\1\171\1\147"+
        "\1\172\1\171\1\145\1\151\1\154\1\145\1\154\1\164\1\145\1\164\1\172"+
        "\1\151\1\141\2\155\1\154\1\55\1\145\1\141\1\156\1\uffff\1\164\1"+
        "\151\2\uffff\1\164\1\166\1\162\1\163\1\162\2\163\1\156\1\uffff\1"+
        "\172\1\141\1\157\1\154\1\162\1\145\1\172\1\55\1\151\1\uffff\1\156"+
        "\1\164\2\151\1\55\1\144\1\172\1\163\1\172\1\162\1\164\1\151\1\145"+
        "\3\172\1\164\2\172\1\uffff\1\163\1\154\1\172\1\145\1\155\1\uffff"+
        "\1\165\1\155\1\172\1\151\2\172\1\164\1\165\1\146\1\uffff\1\145\2"+
        "\uffff\1\141\1\151\1\166\1\144\3\uffff\1\55\1\167\2\uffff\1\145"+
        "\1\141\1\uffff\1\156\1\172\1\160\1\157\1\145\1\uffff\1\157\2\145"+
        "\1\151\1\162\1\164\1\172\1\151\1\157\1\145\1\uffff\1\55\1\157\1"+
        "\151\1\172\1\164\1\143\1\uffff\1\172\1\167\1\172\1\156\2\172\1\155"+
        "\1\151\1\145\1\uffff\2\156\1\55\1\uffff\1\156\1\164\1\uffff\2\145"+
        "\1\uffff\1\156\1\142\1\uffff\1\172\2\uffff\1\145\1\156\1\162\1\164"+
        "\2\141\1\143\1\150\1\144\2\172\1\146\1\145\1\uffff\1\172\1\147\1"+
        "\172\1\163\1\uffff\1\143\1\145\1\151\1\172\2\uffff\1\164\1\146\1"+
        "\uffff\1\172\2\uffff\1\164\1\172\1\156\1\uffff\1\145\1\157\2\uffff"+
        "\1\151\1\uffff\1\172\2\162\1\157\1\uffff\1\172\1\145\1\156\1\uffff"+
        "\1\172\1\163\2\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\uffff\1\7\11\uffff\1\43\1\44\1\45\2"+
        "\uffff\1\50\4\uffff\1\105\1\107\1\110\1\111\2\uffff\1\5\7\uffff"+
        "\1\63\1\64\1\65\1\66\1\104\25\uffff\1\51\1\46\1\52\1\47\1\uffff"+
        "\1\106\10\uffff\1\11\2\uffff\1\17\1\16\1\21\2\uffff\1\62\7\uffff"+
        "\1\34\3\uffff\1\23\33\uffff\1\37\1\uffff\1\24\1\22\1\uffff\1\40"+
        "\26\uffff\1\6\2\uffff\1\14\1\20\10\uffff\1\35\11\uffff\1\42\23\uffff"+
        "\1\25\5\uffff\1\36\11\uffff\1\2\1\uffff\1\4\1\13\4\uffff\1\10\1"+
        "\26\1\12\2\uffff\1\73\1\53\2\uffff\1\27\5\uffff\1\75\12\uffff\1"+
        "\31\6\uffff\1\61\11\uffff\1\57\3\uffff\1\41\2\uffff\1\56\2\uffff"+
        "\1\54\2\uffff\1\74\1\uffff\1\67\1\70\15\uffff\1\60\4\uffff\1\32"+
        "\4\uffff\1\33\1\55\2\uffff\1\71\1\uffff\1\103\1\15\3\uffff\1\72"+
        "\2\uffff\1\102\1\15\1\uffff\1\76\4\uffff\1\101\3\uffff\1\77\2\uffff"+
        "\1\100\1\30";
    static final String DFA10_specialS =
        "\u0150\uffff}>";
    static final String[] DFA10_transitionS = {
            "\2\34\2\uffff\1\34\22\uffff\1\34\7\uffff\1\1\1\3\1\17\1\20"+
            "\1\uffff\1\5\1\uffff\1\21\12\32\1\4\1\33\1\23\1\24\1\22\1\25"+
            "\1\uffff\32\31\6\uffff\1\10\2\31\1\2\1\6\1\13\1\31\1\30\1\12"+
            "\3\31\1\26\1\7\1\11\1\14\2\31\1\15\1\27\2\31\1\16\3\31",
            "",
            "\1\35\11\uffff\1\36",
            "",
            "\1\44\1\uffff\1\42\1\46\1\45\1\41\1\51\1\uffff\1\50\3\uffff"+
            "\1\52\1\53\1\47\1\43\1\53\1\37\1\53\1\40\1\53",
            "",
            "\1\54\4\uffff\1\56\11\uffff\1\55",
            "\1\60\5\uffff\1\57",
            "\1\63\1\uffff\1\61\4\uffff\1\64\1\62",
            "\1\65\3\uffff\1\66",
            "\1\67\1\70\4\uffff\1\71",
            "\1\72",
            "\1\73",
            "\1\75\13\uffff\1\76\4\uffff\1\74",
            "\1\77\1\100",
            "",
            "",
            "",
            "\1\101",
            "\1\103",
            "",
            "\32\106\6\uffff\3\106\1\105\26\106",
            "\1\110\7\uffff\1\107",
            "\1\111",
            "\1\112",
            "",
            "",
            "",
            "",
            "\1\114\2\uffff\1\113",
            "\1\115",
            "",
            "\1\53\17\uffff\1\116",
            "\1\53\10\uffff\1\117",
            "\1\120",
            "\1\122\20\uffff\1\121",
            "\1\123\1\53",
            "\1\124\12\uffff\1\53\6\uffff\1\53",
            "\1\126\3\uffff\1\53\5\uffff\1\127\5\uffff\1\125",
            "",
            "",
            "",
            "",
            "",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\140\12\uffff\1\141",
            "\1\142",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151\11\uffff\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "",
            "",
            "",
            "",
            "\1\160",
            "",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "",
            "\1\171",
            "\1\172",
            "",
            "",
            "",
            "\1\173",
            "\1\174",
            "",
            "\1\175",
            "\1\176",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u0080",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u0083",
            "",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u0085",
            "\1\u0086",
            "",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b\3\uffff\1\53",
            "\1\u009d\16\uffff\1\u009c",
            "\1\u009f\1\u009e\1\uffff\1\53",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "",
            "\1\u00a4",
            "",
            "",
            "\1\u00a5",
            "",
            "\1\u00a6",
            "\1\u00a7",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "",
            "\1\u00bc",
            "\1\u00bd",
            "",
            "",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u00cd",
            "\1\u00ce",
            "",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d5\2\uffff\1\u00d4",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u00d7",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u00d9\20\uffff\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u00e1",
            "\1\u00e2\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff"+
            "\32\31",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "",
            "\1\u00e5",
            "\1\u00e6",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u00e8",
            "\1\u00e9",
            "",
            "\1\u00eb\20\uffff\1\u00ea",
            "\1\u00ec",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "",
            "\1\u00f4",
            "",
            "",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f8\6\uffff\1\u00f7",
            "\1\u00f9",
            "",
            "",
            "",
            "\1\u00fa",
            "\1\u00fb",
            "",
            "",
            "\1\u00fc",
            "\1\u00fd",
            "",
            "\1\u00fe",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "",
            "\1\53",
            "\1\u010e",
            "\1\u010f",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u0111",
            "\1\u0112",
            "",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u0114",
            "\1\u0115\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff"+
            "\32\31",
            "\1\u0117",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "",
            "\1\u0120",
            "\1\u0121",
            "",
            "\1\u0122",
            "\1\u0123",
            "",
            "\1\u0124",
            "\1\u0125\1\u0126",
            "",
            "\1\106\2\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff"+
            "\32\106",
            "",
            "",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "\1\53",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u0133",
            "\1\u0134",
            "",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u0136",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u0138",
            "",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "",
            "",
            "\1\u013d",
            "\1\u013e",
            "",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "",
            "",
            "\1\u0141",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u0143",
            "",
            "\1\u0144",
            "\1\u0145",
            "",
            "",
            "\1\u0146",
            "",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\u014c",
            "\1\u014d",
            "",
            "\1\31\2\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\53",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | REQUIRE_KEY | NAME | VARIABLE | NUMBER | LINE_COMMENT | WHITESPACE );";
        }
    }
 

}