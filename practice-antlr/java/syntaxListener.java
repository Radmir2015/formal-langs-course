// Generated from syntax.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link syntaxParser}.
 */
public interface syntaxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link syntaxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(syntaxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link syntaxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(syntaxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link syntaxParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(syntaxParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link syntaxParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(syntaxParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orXorOp}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrXorOp(syntaxParser.OrXorOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orXorOp}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrXorOp(syntaxParser.OrXorOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterParens(syntaxParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitParens(syntaxParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andOp}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndOp(syntaxParser.AndOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andOp}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndOp(syntaxParser.AndOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notOp}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterNotOp(syntaxParser.NotOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notOp}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitNotOp(syntaxParser.NotOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ident}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterIdent(syntaxParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ident}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitIdent(syntaxParser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integer}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterInteger(syntaxParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integer}
	 * labeled alternative in {@link syntaxParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitInteger(syntaxParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printId}
	 * labeled alternative in {@link syntaxParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrintId(syntaxParser.PrintIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printId}
	 * labeled alternative in {@link syntaxParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrintId(syntaxParser.PrintIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link syntaxParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(syntaxParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link syntaxParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(syntaxParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link syntaxParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(syntaxParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link syntaxParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(syntaxParser.AssignExprContext ctx);
}